package com.bz.mapReduce;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.CombineTextInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class FlowCount {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        /**
         * 访问本地
         */
        conf.set("mapreduce.framework.name","local");
        //默认
        //conf.set("fs.defauleFS", "file:///");
        //conf.set("fs.defauleFS", "hdfs://bz1:9090/");

        Job job = Job.getInstance(conf);

        //指定本程序的jar包所在路径
        job.setJarByClass(FlowCount.class);

        //指定本业务job要使用的mapper/Reduce业务类
        job.setMapperClass(YwMapper.class);
        job.setReducerClass(YwReduce.class);

        //指定我们自定义的数据分区
        job.setPartitionerClass(ProvincePartitioner.class);
        //指定分区数量的reducetask
        job.setNumReduceTasks(1);

        //指定mapper输出数据的kv类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean .class);

        //job.setCombinerClass(CombineTextInputFormat.class);

        //指定job的输入原文件目录
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        Path path = new Path(args[1]);
        FileSystem fs = FileSystem.get(conf);
        if(fs.exists(path)){
            fs.delete(path,true);
        }

        //指定job的输出结果目录
        FileOutputFormat.setOutputPath(job,new Path(args[1]));



        //提交给yarn运行
        boolean res = job.waitForCompletion(true);
        System.exit(res?0:1);
    }

}
