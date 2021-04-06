package com.blamejared.appliedenergisticstweaker.handlers;

import com.blamejared.appliedenergisticstweaker.actions.*;
import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.impl.tag.MCTag;
import net.minecraft.item.Item;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.appliedenergistics2.Cannon")
public class CannonHandler {
    
    @ZenCodeType.Method
    public static void setAmmo(IItemStack ingredient, double weight) {
        
        CraftTweakerAPI.apply(new ActionSetAmmoItem(ingredient, weight));
    }
    
    @ZenCodeType.Method
    public static void setAmmo(MCTag<Item> tag, double weight) {
        
        CraftTweakerAPI.apply(new ActionSetAmmoTag(tag, weight));
    }
}
