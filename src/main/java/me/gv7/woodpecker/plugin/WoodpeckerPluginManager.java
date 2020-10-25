package me.gv7.woodpecker.plugin;

import me.gv7.woodpecker.vuldb.JacksonVulPlugin;

public class WoodpeckerPluginManager implements IPluginManager {
    @Override
    public void registerPluginManagerCallbacks(IPluginManagerCallbacks iPluginManagerCallbacks) {
        iPluginManagerCallbacks.registerVulPlugin(new JacksonVulPlugin());
    }
}
