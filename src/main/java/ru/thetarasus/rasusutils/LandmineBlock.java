package ru.thetarasus.rasusutils;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.Hopper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.explosion.Explosion;

import java.util.List;
import java.util.Random;

public class LandmineBlock extends Block {
    public LandmineBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.POWERED, false).with(Properties.TRIGGERED, false).with(Properties.ATTACHED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.POWERED).add(Properties.TRIGGERED).add(Properties.ATTACHED);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(state.get(Properties.POWERED) || state.get(Properties.ATTACHED)) return ActionResult.PASS;
        if(world.isClient) return ActionResult.PASS;
        world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, SoundCategory.BLOCKS, 1, 1);
        world.createAndScheduleBlockTick(pos, this, 600);
        Random r = new Random();
        ((ServerWorld)world).spawnParticles(ParticleTypes.PORTAL, pos.getX()+0.5, pos.getY()+0.25, pos.getZ()+0.5, 25, r.nextFloat() * 0.05, r.nextFloat() * 0.05, r.nextFloat() * 0.05, 1);

        world.setBlockState(pos, state.with(Properties.ATTACHED, true));
        return ActionResult.SUCCESS;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if(world.isClient) return;
        if(state.get(Properties.TRIGGERED)) return;
        if(!state.get(Properties.POWERED)) return;
        if(!(entity instanceof PlayerEntity)) return;
        boolean isNotInSurvival = ((PlayerEntity) entity).isSpectator() || ((PlayerEntity) entity).isCreative();
        if(isNotInSurvival) return;
        Random r = new Random();
        world.setBlockState(pos, state.with(Properties.TRIGGERED, true));
        world.playSound(null, pos, SoundEvents.ENTITY_TURTLE_EGG_BREAK, SoundCategory.BLOCKS, 1f, 0.6f);
        world.createAndScheduleBlockTick(pos, this, r.nextInt(20));
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        Random r = new Random();
        if(!state.get(Properties.POWERED) && !state.get(Properties.TRIGGERED)) {
            world.setBlockState(pos, state.with(Properties.POWERED, true));
            world.playSound(null, pos, SoundEvents.ENTITY_BEE_STING, SoundCategory.BLOCKS, 1f,0.85f + (r.nextFloat()*0.3f));
            return;
        }
        world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 4.5f,1 + (r.nextFloat()*0.15f));

        BlockStateParticleEffect effect = new BlockStateParticleEffect(ParticleTypes.BLOCK, world.getBlockState(pos.down()));
        world.spawnParticles(ParticleTypes.CLOUD, pos.getX()+0.5, pos.getY()+0.25, pos.getZ()+0.5, 100, r.nextFloat() * 0.05, r.nextFloat() * 2, r.nextFloat() * 0.05, 1);
        world.spawnParticles(effect, pos.getX()+0.5, pos.getY()+0.25, pos.getZ()+0.5, 256, r.nextFloat() * 0.15, r.nextFloat() * 6, r.nextFloat() * 0.15, 1);
        List<Entity> entities = world.getOtherEntities(null, new Box(pos.add(-2, 0, -2), pos.add(2, 3, 2)));
        Explosion explosion = new Explosion(world, null, pos.getX(), pos.getY(), pos.getZ(), 5, false, Explosion.DestructionType.NONE);
        for(Entity entity : entities) {
            entity.setVelocity(0, 1, 0);
            entity.damage(DamageSource.explosion(explosion), 20);
        }
        world.setBlockState(pos, Blocks.AIR.getDefaultState());
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if(world.isClient()) return false;
        BlockPos spawn = ((ServerWorld)world).getSpawnPos();
        boolean isNearTheSpawn = pos.getX() > spawn.getX() - 512 && pos.getX() < spawn.getX() + 512 && pos.getZ() > spawn.getZ() - 512 && pos.getZ() < spawn.getZ() + 512;
        if(isNearTheSpawn) return false;
        return world.getBlockState(pos.down()).isOpaqueFullCube(world, pos.down());
    }
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(Properties.POWERED) ? VoxelShapes.empty() : Block.createCuboidShape(6, 0, 6, 10, 5, 10);
    }

    @Override
    public VoxelShape getRaycastShape(BlockState state, BlockView world, BlockPos pos) {
        return state.get(Properties.POWERED) ? VoxelShapes.empty() : Block.createCuboidShape(6, 0, 6, 10, 5, 10);
    }
}
