package com.blamejared.appliedenergisticstweaker.actions;

import appeng.core.Api;
import com.blamejared.crafttweaker.api.actions.IUndoableAction;
import com.blamejared.crafttweaker.impl.tag.MCTag;
import net.minecraft.item.Item;
import net.minecraftforge.fml.LogicalSide;

public class ActionSetAmmoTag implements IUndoableAction {
    
    private final MCTag<Item> stack;
    private final double weight;
    
    private final double oldWeight;
    
    public ActionSetAmmoTag(MCTag<Item> stack, double weight) {
        this.stack = stack;
        this.weight = weight;
        this.oldWeight = Api.instance().registries().matterCannon().getPenetration(stack.getElements().get(0).getDefaultInstance());
    }
    
    @Override
    public void apply() {
        Api.instance().registries().matterCannon().registerAmmoTag(stack.getId(), weight);
    }
    
    @Override
    public String describe() {
        return String.format("Registering Tag %s with a weight of %s to the Applied Energistics 2 Matter Cannon", stack.getCommandString(), weight);
    }
    
    @Override
    public void undo() {
        Api.instance().registries().matterCannon().registerAmmoTag(stack.getId(), oldWeight);
    }
    
    @Override
    public String describeUndo() {
        return String.format("Unregistering Tag %s with a weight of %s to the Applied Energistics 2 Matter Cannon", stack.getCommandString(), weight);
    }
    
    @Override
    public boolean shouldApplyOn(LogicalSide side) {
        return shouldApplySingletons();
    }
}
