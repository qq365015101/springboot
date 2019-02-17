package com.bz.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

public class HdfsClientDemo {

    FileSystem fs;

    @Before
    public void init() throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","HDFS://bz1:9000");
        fs = FileSystem.get(new URI("hdfs://bz1:9000"),conf,"hadoop");
    }

    @Test
    public void testUpload() throws Exception {
        fs.copyFromLocalFile(new Path("C:\\Users\\bz\\Desktop\\新建文件夹\\meng.txt"),new Path("/test"));
        fs.close();
    }


}
