package com.otakusaikou.plantcraft.block;

import com.otakusaikou.plantcraft.PlantCraft;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, PlantCraft.MOD_ID);

    public static final RegistryObject<CropStickBlock> cropStickBlock = REGISTER.register("crop_stick_block", () -> new CropStickBlock(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(3).doesNotBlockMovement()));
}
