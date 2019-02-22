package com.bz.mapReduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * KEYIN：默认情况下，是mr框架所读到的一行文本的起始偏移量
 *        但是在hadoop中有自己的更精简的序列化接口，所以不直接用Long，而用LongWritable
 *
 * VALUEIN：默认情况下，是mr框架所读到的一行文本的内容，String
 *
 * KEYOUT：是用户自定义逻辑处理完成后输出数据中的key，
 *
 * VALUEOUT：是用户自定义逻辑处理完成后输出数据中的value
 *
 *
 */
public class YwMapper extends Mapper<LongWritable, Text, Text, FlowBean>{

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //取一行数据
        String line = value.toString();
        String[] values = line.split(" ");
        String phoneNum = values[0];
        long upFlow = Long.parseLong(values[1]);
        long dFlow = Long.parseLong(values[2]);

        context.write(new Text(phoneNum),new FlowBean(upFlow, dFlow));
    }


}
