package com.bz.mapReduce;


import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlowBean implements Writable {

    private Long upFlow;
    private Long dFlow;
    private Long sum_flow;

    /**
     * 供反射时调用
     */
    public FlowBean() {
    }

    public FlowBean(Long upFlow, Long dFlow) {
        this.upFlow = upFlow;
        this.dFlow = dFlow;
        this.sum_flow = upFlow + dFlow;
    }

    public Long getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(Long upFlow) {
        this.upFlow = upFlow;
    }

    public Long getdFlow() {
        return dFlow;
    }

    public void setdFlow(Long dFlow) {
        this.dFlow = dFlow;
    }

    public Long getSum_flow() {
        return sum_flow;
    }

    public void setSum_flow(Long sum_flow) {
        this.sum_flow = sum_flow;
    }

    /**
     * 序列化方法
     * @param out
     * @throws IOException
     */
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeLong(upFlow);
        out.writeLong(dFlow);
    }

    /**
     * 反序列化方法
     * 注意：序列化的顺序跟反序列化的顺序一样
     * @param in
     * @throws IOException
     */
    @Override
    public void readFields(DataInput in) throws IOException {
        upFlow = in.readLong();
        dFlow = in.readLong();
    }

    @Override
    public String toString() {
        return upFlow + " " + dFlow + " " +sum_flow;
    }
}
