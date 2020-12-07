package com.otakusaikou.plantcraft.item;

import com.otakusaikou.plantcraft.PlantCraft;
import com.otakusaikou.plantcraft.block.BlockRegistry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, PlantCraft.MOD_ID);

    //BlockItem
    public static final RegistryObject<BlockItem> cropStickItem = REGISTER.register("crop_stick_item", () -> new BlockItem(BlockRegistry.cropStickBlock.get(), new Item.Properties()));
}
