package com.blamejared.appliedenergisticstweaker.actions.spatial;

import appeng.core.Api;
import com.blamejared.crafttweaker.api.actions.IAction;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.LogicalSide;

public class ActionWhitelistEntity implements IAction {
    
    private final Class<? extends TileEntity> tile;
    
    public ActionWhitelistEntity(Class<? extends TileEntity> tile) {
        this.tile = tile;
    }
    
    @Override
    public void apply() {
        Api.instance().registries().movable().whiteListTileEntity(tile);
    }
    
    @Override
    public String describe() {
        return "Whitelisting " + tile + " to the Applied Energistics 2 movable registry.";
    }
    
    @Override
    public boolean shouldApplyOn(LogicalSide side) {
        return shouldApplySingletons();
    }
}
