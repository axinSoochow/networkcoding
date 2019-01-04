package com.suda.edu.networkcoding.algorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 专利中描述的避免冲突的网络编码方法
 * 其效果和oncsb方法相同，oncsb方法复杂度会更小一点
 *
 */
@Component("cdncwbr")
public class CdNcwmr implements  NetworkCode{

    @Autowired
    @Qualifier("oncsb")
    NetworkCode cdncwbr;

    @Override
    public int[] getCodePacket(int[][] MPEM) {
        return cdncwbr.getCodePacket(MPEM);
    }

}
