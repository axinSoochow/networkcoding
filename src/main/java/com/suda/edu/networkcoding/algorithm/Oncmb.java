package com.suda.edu.networkcoding.algorithm;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 多组合分组广播传输——《基于机会式网络编码的高效广播传输算法》
 * oncmb算法要求接收点具有缓存功能，其算法步骤和ncwbr算法一样，解码步骤不同
 *
 * @author Axin
 * @date 2018-11-1
 */
@Component("oncmb")
public class Oncmb implements NetworkCode {

    @Autowired
    @Qualifier("ncwbr")
    NetworkCode ncwbr;

    @Override
    public int[] getCodePacket(int[][] MPEM) {
        return ncwbr.getCodePacket(MPEM);
    }
}
