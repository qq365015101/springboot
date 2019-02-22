package com.bz.mapReduce;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import java.util.HashMap;


public class ProvincePartitioner extends Partitioner<Text,FlowBean> {
    @Override
    public int getPartition(Text key, FlowBean flowBean, int i) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("136", 1);
        map.put("137", 2);

        CharSequence prefix = key.toString().subSequence(0, 3);
        Integer provinceId = map.get(prefix);

        return provinceId == null ? 3 : provinceId;
    }
}
