package com.blamejared.appliedenergisticstweaker.actions;

import appeng.core.Api;
import com.blamejared.crafttweaker.api.actions.IUndoableAction;
import com.blamejared.crafttweaker.api.item.IItemStack;
import net.minecraftforge.fml.LogicalSide;

public class ActionSetAmmoItem implements IUndoableAction {
    
    private final IItemStack stack;
    private final double weight;
    
    private final double oldWeight;
    
    public ActionSetAmmoItem(IItemStack stack, double weight) {
        this.stack = stack;
        this.weight = weight;
        this.oldWeight = Api.instance().registries().matterCannon().getPenetration(stack.getInternal());
    }
    
    @Override
    public void apply() {
        Api.instance().registries().matterCannon().registerAmmoItem(stack.getInternal().getItem(), weight);
    }
    
    @Override
    public String describe() {
        return String.format("Setting the weight of  %s to %s for the Applied Energistics 2 Matter Cannon", stack.getCommandString(), weight);
    }
    
    @Override
    public void undo() {
        Api.instance().registries().matterCannon().registerAmmoItem(stack.getInternal().getItem(), oldWeight);
    }
    
    @Override
    public String describeUndo() {
        return String.format("Unsetting the weight of  %s to %s for the Applied Energistics 2 Matter Cannon", stack.getCommandString(), weight);
    }
    
    @Override
    public boolean shouldApplyOn(LogicalSide side) {
        return shouldApplySingletons();
    }
    
}
