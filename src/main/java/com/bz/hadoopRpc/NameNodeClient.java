package com.bz.hadoopRpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

public class NameNodeClient {


    public static void main(String[] args) throws Exception {
        INameNodeService nameNode = RPC.getProxy(INameNodeService.class, 1L, new InetSocketAddress("localhost", 3636), new Configuration());
        String result = nameNode.getMetaData("/test");
        System.out.println(result);
    }

}
