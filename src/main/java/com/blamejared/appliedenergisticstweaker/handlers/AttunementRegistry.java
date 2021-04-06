package com.blamejared.appliedenergisticstweaker.handlers;


import appeng.api.config.TunnelType;
import com.blamejared.appliedenergisticstweaker.actions.attunement.*;
import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.item.IIngredient;
import org.openzen.zencode.java.ZenCodeType;


@ZenCodeType.Name("mods.appliedenergistics2.Attunement")
public class AttunementRegistry {
    
    @ZenCodeType.Method
    public static void attuneME(IIngredient itemStack) {
        attune(itemStack, TunnelType.ME);
    }
    
    @ZenCodeType.Method
    public static void attuneME(String modId) {
        attune(modId, TunnelType.ME);
    }
    
    @ZenCodeType.Method
    public static void attuneItem(IIngredient itemStack) {
        attune(itemStack, TunnelType.ITEM);
    }
    
    @ZenCodeType.Method
    public static void attuneItem(String modId) {
        attune(modId, TunnelType.ITEM);
    }
    
    @ZenCodeType.Method
    public static void attuneFluid(IIngredient itemStack) {
        attune(itemStack, TunnelType.FLUID);
    }
    
    @ZenCodeType.Method
    public static void attuneFluid(String modId) {
        attune(modId, TunnelType.FLUID);
    }
    
    @ZenCodeType.Method
    public static void attuneRedstone(IIngredient itemStack) {
        attune(itemStack, TunnelType.REDSTONE);
    }
    
    @ZenCodeType.Method
    public static void attuneRedstone(String modId) {
        attune(modId, TunnelType.REDSTONE);
    }
    
    @ZenCodeType.Method
    public static void attuneRF(IIngredient itemStack) {
        attune(itemStack, TunnelType.FE_POWER);
    }
    
    @ZenCodeType.Method
    public static void attuneRF(String modId) {
        attune(modId, TunnelType.FE_POWER);
    }
    
    @ZenCodeType.Method
    public static void attuneIC2(IIngredient itemStack) {
        attune(itemStack, TunnelType.IC2_POWER);
    }
    
    @ZenCodeType.Method
    public static void attuneIC2(String modId) {
        attune(modId, TunnelType.IC2_POWER);
    }
    
    @ZenCodeType.Method
    public static void attuneLight(IIngredient itemStack) {
        attune(itemStack, TunnelType.LIGHT);
    }
    
    @ZenCodeType.Method
    public static void attuneLight(String modId) {
        attune(modId, TunnelType.LIGHT);
    }
    
    private static void attune(IIngredient itemStack, TunnelType type) {
        CraftTweakerAPI.apply(new ActionAddAttunement(itemStack, type));
    }
    
    private static void attune(String modid, TunnelType type) {
        CraftTweakerAPI.apply(new ActionAddModidAttunement(modid, type));
    }
}