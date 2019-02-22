package com.bz.mapReduce;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class YwReduce extends Reducer<Text, FlowBean, Text, FlowBean> {

    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
        long sum_upFlow = 0;
        long sum_dFlow = 0;

        for(FlowBean value : values){
            sum_upFlow += value.getUpFlow();
            sum_dFlow += value.getdFlow();
        }

        FlowBean resultBean = new FlowBean(sum_upFlow, sum_dFlow);

        context.write(key,resultBean);
    }
}
