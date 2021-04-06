package com.blamejared.appliedenergisticstweaker.actions.attunement;

import appeng.api.config.TunnelType;
import appeng.core.Api;
import com.blamejared.crafttweaker.api.actions.*;
import com.blamejared.crafttweaker.api.item.IIngredient;
import net.minecraftforge.fml.LogicalSide;

import java.util.Arrays;

public class ActionAddAttunement implements IAction {
    
    private final IIngredient ingredient;
    private final TunnelType type;
    
    public ActionAddAttunement(IIngredient ingredient, TunnelType type) {
        this.ingredient = ingredient;
        this.type = type;
    }
    
    @Override
    public void apply() {
        Arrays.stream(ingredient.getItems()).forEach(iItemStack -> {
            Api.instance().registries().p2pTunnel().addNewAttunement(iItemStack.getInternal(), type);
        });
    }
    
    @Override
    public String describe() {
        return "Setting Attunement of " + ingredient.getCommandString() + " to: " + type;
    }
    
    @Override
    public boolean shouldApplyOn(LogicalSide side) {
        return shouldApplySingletons();
    }
}
