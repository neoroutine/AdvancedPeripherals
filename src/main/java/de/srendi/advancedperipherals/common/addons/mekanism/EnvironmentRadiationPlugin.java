package de.srendi.advancedperipherals.common.addons.mekanism;

import dan200.computercraft.api.lua.LuaFunction;
import de.srendi.advancedperipherals.common.addons.computercraft.owner.IPeripheralOwner;
import de.srendi.advancedperipherals.lib.peripherals.IPeripheralPlugin;
import mekanism.api.Coord4D;
import mekanism.api.MekanismAPI;

public class EnvironmentRadiationPlugin implements IPeripheralPlugin {
    private final IPeripheralOwner owner;

    public EnvironmentRadiationPlugin(IPeripheralOwner owner) {
        this.owner = owner;
    }

    @LuaFunction(mainThread = true)
    public final double getRadiation() {
        return MekanismAPI.getRadiationManager().getRadiationLevel(new Coord4D(owner.getPos(), owner.getLevel()));
    }

}