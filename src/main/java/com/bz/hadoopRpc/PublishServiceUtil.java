package com.bz.hadoopRpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;


public class PublishServiceUtil {

    public static void main(String[] args) throws Exception {
        RPC.Builder builder = new RPC.Builder(new Configuration());

        builder.setBindAddress("localhost")
                .setPort(3636)
                .setProtocol(INameNodeService.class)
                .setInstance(new NameNodeService());

        RPC.Server server = builder.build();
        server.start();
    }

}
