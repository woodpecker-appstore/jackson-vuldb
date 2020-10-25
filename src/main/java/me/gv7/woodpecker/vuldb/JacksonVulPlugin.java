package me.gv7.woodpecker.vuldb;

import me.gv7.woodpecker.plugin.IPayloadGenerator;
import me.gv7.woodpecker.plugin.IPluginHelper;
import me.gv7.woodpecker.plugin.IVulPlugin;
import me.gv7.woodpecker.plugin.IVulPluginCallbacks;
import me.gv7.woodpecker.vuldb.payload.*;

import java.util.ArrayList;
import java.util.List;

public class JacksonVulPlugin implements IVulPlugin {
    public static IVulPluginCallbacks callbacks;
    public static IPluginHelper pluginHelper;

    @Override
    public void VulPluginMain(IVulPluginCallbacks callbacks) {
        this.callbacks = callbacks;
        this.pluginHelper = callbacks.getPluginHelper();
        callbacks.setVulPluginName("Jackson deserialization");
        callbacks.setVulPluginVersion("0.1.0");
        callbacks.setVulPluginAuthor("c0ny1");
        callbacks.setVulName("Jackson deserialization");
        callbacks.setVulCVSS(9.8);
        callbacks.setVulAuthor("");
        callbacks.setVulSeverity("high");
        callbacks.setVulScope("");
        callbacks.setVulDescription("");
        callbacks.setVulCategory("综合");
        callbacks.setVulProduct("fastjson");
        List<IPayloadGenerator> payloadGeneratorList = new ArrayList<IPayloadGenerator>();
        payloadGeneratorList.add(new JndiInjectPayloadGenerator());
        payloadGeneratorList.add(new LocalPayloadGenerator());
        callbacks.registerPayloadGenerator(payloadGeneratorList);
    }
}
