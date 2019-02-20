package com.bz.hadoopRpc;

public interface INameNodeService{

    public static long versionID = 1L;

    String getMetaData(String path) throws Exception;
}
