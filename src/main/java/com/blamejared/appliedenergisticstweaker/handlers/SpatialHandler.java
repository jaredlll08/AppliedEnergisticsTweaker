package com.blamejared.appliedenergisticstweaker.handlers;

import com.blamejared.appliedenergisticstweaker.actions.spatial.ActionWhitelistEntity;
import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import net.minecraft.tileentity.TileEntity;
import org.openzen.zencode.java.ZenCodeType;

@ZenCodeType.Name("mods.appliedenergistics2.Spatial")
public class SpatialHandler {
    
    @ZenCodeType.Method
    public static void whitelistEntity(String entityClassName) {
        Class<? extends TileEntity> entityClass = loadClass(entityClassName);
        if(entityClass != null) {
            CraftTweakerAPI.apply(new ActionWhitelistEntity(entityClass));
        }
    }
    
    @SuppressWarnings("unchecked")
    private static Class<? extends TileEntity> loadClass(String className) {
        try {
            return (Class<? extends TileEntity>) Class.forName(className);
        } catch(Exception e) {
            CraftTweakerAPI.logError("Failed to load TileEntity class '" + className + "'", e);
        }
        return null;
    }
    
}
