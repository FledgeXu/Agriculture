package com.otakusaikou.plantcraft;

import com.otakusaikou.plantcraft.block.BlockRegistry;
import com.otakusaikou.plantcraft.item.ItemRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PlantCraft.MOD_ID)
public class PlantCraft {
    public static final String MOD_ID = "plantcraft";

    public PlantCraft() {
        IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BlockRegistry.REGISTER.register(iEventBus);
        ItemRegistry.REGISTER.register(iEventBus);
    }
}
