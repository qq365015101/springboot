package com.bz.hadoopRpc;


public class NameNodeService implements INameNodeService{
    @Override
    public String getMetaData(String path) throws Exception{
        return path + ": 3 - {BLK_1,BLK_2}";
    }
}
