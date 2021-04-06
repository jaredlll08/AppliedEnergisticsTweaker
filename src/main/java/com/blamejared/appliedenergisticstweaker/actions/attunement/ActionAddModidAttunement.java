package com.blamejared.appliedenergisticstweaker.actions.attunement;

import appeng.api.config.TunnelType;
import appeng.core.Api;
import com.blamejared.crafttweaker.api.actions.IAction;
import net.minecraftforge.fml.LogicalSide;

public class ActionAddModidAttunement implements IAction {
    
    private final String modid;
    private final TunnelType type;
    
    public ActionAddModidAttunement(String modid, TunnelType type) {
        this.modid = modid;
        this.type = type;
    }
    
    @Override
    public void apply() {
        Api.instance().registries().p2pTunnel().addNewAttunement(modid, type);
    }
    
    @Override
    public String describe() {
        return "Setting Attunement of " + modid + " to: " + type;
    }
    
    @Override
    public boolean shouldApplyOn(LogicalSide side) {
        return shouldApplySingletons();
    }
}
