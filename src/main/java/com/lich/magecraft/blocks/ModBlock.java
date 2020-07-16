package com.lich.magecraft.blocks;

import com.lich.magecraft.Magecraft;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("magecraft")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlock {

    //name blocks here

    //simple blocks
    @ObjectHolder("elder_planks")
    public static Block ELDER_PLANKS;
    @ObjectHolder("elder_log")
    public static ElderLogBlock ELDER_LOG;
    @ObjectHolder("stripped_elder_log")
    public static StrippedElderLogBlock STRIPPED_ELDER_LOG;
    @ObjectHolder("chiseled_smokey_quartz")
    public static Block CHISELED_SMOKEY_QUARTZ;
    @ObjectHolder("coldiron_block")
    public static Block COLDIRON_BLOCK;
    @ObjectHolder("smokey_quartz_block")
    public static Block SMOKEY_QUARTZ_BLOCK;
    @ObjectHolder("smokey_quartz_ore")
    public static Block SMOKEY_QUARTZ_ORE;
    @ObjectHolder("smokey_quartz_pillar")
    public static Block SMOKEY_QUARTZ_PILLAR;
    @ObjectHolder("crystal_capacitor")
    public static CrystalCapacitorBlock CRYSTAL_CAPACITOR;
    @ObjectHolder("crystal_capacitor_mk2")
    public static CrystalCapacitorMk2Block CRYSTAL_CAPACITOR_MK2;
    @ObjectHolder("elder_bookshelf")
    public static ElderBookshelfBlock ELDER_BOOKSHELF;

    //stairs
    @ObjectHolder("elder_stairs")
    public static StairsBlock ELDER_STAIRS;

    //slabs
    @ObjectHolder("elder_slab")
    public static SlabBlock ELDER_SLAB;

    //walls and fences
    @ObjectHolder("elder_fence")
    public static FenceBlock ELDER_FENCE;

    //doors gates and trapdoors
    @ObjectHolder("elder_door")
    public static DoorBlock ELDER_DOOR;
    @ObjectHolder("elder_trapdoor")
    public static TrapDoorBlock ELDER_TRAPDOOR;

    //Register Blocks here
    @SubscribeEvent
    public static void init(RegistryEvent.Register<Block>event)
    {

        // simple blocks
        ELDER_PLANKS = simpleBlockFactory(event, "elder_planks", Material.WOOD, 2.0F, 3.0F, SoundType.WOOD);

        COLDIRON_BLOCK = simpleBlockFactory(event, "coldiron_block", Material.IRON, 4.0F, 3.0F, SoundType.METAL);

        CHISELED_SMOKEY_QUARTZ = simpleBlockFactory(event, "chiseled_smokey_quartz", Material.ROCK, 0.8F, 0.8F, SoundType.METAL);
        SMOKEY_QUARTZ_BLOCK = simpleBlockFactory(event, "smokey_quartz_block", Material.ROCK, 0.8F, 0.8F, SoundType.METAL);
        SMOKEY_QUARTZ_ORE = simpleBlockFactory(event, "smokey_quartz_ore", Material.ROCK, 0.8F, 0.8F, SoundType.METAL);
        SMOKEY_QUARTZ_PILLAR = simpleBlockFactory(event, "smokey_quartz_pillar", Material.ROCK, 0.8F, 0.8F, SoundType.METAL);


        // blocks with variations
        ELDER_STAIRS = stairsFactory(event, ELDER_PLANKS, "elder_stairs");
        ELDER_SLAB = slabFactory(event, ELDER_PLANKS, "elder_slab");
        ELDER_FENCE = fenceFactory(event, ELDER_PLANKS, "elder_fence");
        ELDER_DOOR = doorFactory(event, ELDER_PLANKS, "elder_door");
        ELDER_TRAPDOOR = trapdoorFactory(event, ELDER_TRAPDOOR, "elder_trapdoor");

        // non-simple block
        registerBlock(new ElderLogBlock(), "elder_log", event);
        registerBlock(new StrippedElderLogBlock(), "stripped_elder_log", event);
        registerBlock(new ElderBookshelfBlock(), "elder_bookshelf", event);

        registerBlock(new CrystalCapacitorBlock(), "crystal_capacitor", event);
        registerBlock(new CrystalCapacitorMk2Block(), "crystal_capacitor_mk2", event);

    }

    //Define Block factories here

    //simple block factory
    public static Block simpleBlockFactory(RegistryEvent.Register<Block> event, String registryName, Material material, Float hardness, Float resistance, SoundType sound)
    {
        Block block = new Block(Block.Properties
                .create(material)
                .hardnessAndResistance(hardness, resistance)
                .sound(sound));

        block.setRegistryName(Magecraft.MOD_ID, registryName);
        event.getRegistry().register(block);

        return block;
    }

    //stairs factory
    public static StairsBlock stairsFactory(RegistryEvent.Register<Block> event, Block block, String registryName)
    {
        StairsBlock stairsBlock = new StairsMod(block);

        stairsBlock.setRegistryName(registryName);
        event.getRegistry().register(stairsBlock);

        return stairsBlock;
    }

    //slab factory
    public static SlabBlock slabFactory(RegistryEvent.Register<Block> event, Block block, String registryName)
    {
        SlabBlock slabBlock = new SlabBlock(Block.Properties.from(block));

        slabBlock.setRegistryName(registryName);
        event.getRegistry().register(slabBlock);

        return slabBlock;
    }

    //fence factory
    public static FenceBlock fenceFactory(RegistryEvent.Register<Block> event, Block block, String registryName)
    {
        FenceBlock fenceBlock = new FenceBlock(Block.Properties.from(block));

        fenceBlock.setRegistryName(registryName);
        event.getRegistry().register(fenceBlock);

        return fenceBlock;
    }

    //wall factory
    public static WallBlock wallFactory(RegistryEvent.Register<Block> event, Block block, String registryName) {
        WallBlock wallBlock = new WallBlock(Block.Properties.from(block));

        wallBlock.setRegistryName(registryName);
        event.getRegistry().register(wallBlock);

        return wallBlock;
    }

    //door factory
    public static DoorBlock doorFactory(RegistryEvent.Register<Block> event, Block block, String registryName) {
        DoorBlock doorBlock = new DoorMod(block);

        doorBlock.setRegistryName(registryName);
        event.getRegistry().register(doorBlock);

        return doorBlock;
    }

    // trapdoor factory
    public static TrapDoorBlock trapdoorFactory(RegistryEvent.Register<Block> event, Block block, String registryName) {
        TrapDoorBlock trapDoorBlock = new TrapDoorBlock(Block.Properties.from(block));

        trapDoorBlock.setRegistryName(registryName);
        event.getRegistry().register(trapDoorBlock);

        return trapDoorBlock;
    }

    //non-simple block factory
    public static void registerBlock(Block block, String registryName, RegistryEvent.Register<Block> event)
    {
        block.setRegistryName(registryName);
        event.getRegistry().register(block);
    }

}
