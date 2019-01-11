package com.suda.edu.networkcoding.algorithm;

import com.suda.edu.networkcoding.tools.MatrixTools;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * 基于冲突检测的网络编码重传包组合算法
 * 其效果和oncsb方法相同，oncsb方法复杂度会更小一点
 */
@Component("cdncwbr")
public class CdNcwmr implements NetworkCode {

    @Override
    public int[] getCodePacket(int[][] MPEM) {
        int row = MPEM.length;
        int col = MPEM[0].length;
        Set<Integer> temp = new HashSet<>();

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (MPEM[j][i] == 1) {
                    temp.add(i);
                    //如果编码冲突
                    if (!codeDetection(temp, MPEM)) {
                        //移除刚增加的列
                        temp.remove(i);
                    }
                    break;
                }
            }
            //终止搜索机制
            if (bestFit(temp, MPEM)) {
                break;
            }
        }
        int[] codePacket = MatrixTools.setToArray(temp);
        return codePacket;
    }

    /**
     * 冲突检测
     * 反馈true表明编码不冲突
     *
     * @param temp
     * @param MPEM
     * @return
     */
    private boolean codeDetection(Set<Integer> temp, int[][] MPEM) {
        int[] codePacket = MatrixTools.setToArray(temp);
        for (int i = 0; i < MPEM.length; i++) {
            int sum = 0;
            for (int j = 0; j < temp.size(); j++) {
                sum += MPEM[i][codePacket[j]];
            }
            if (sum > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 终止搜索机制
     * 返回true表明已完成最佳匹配
     *
     * @param temp
     * @param MPEM
     * @return
     */
    private boolean bestFit(Set<Integer> temp, int[][] MPEM) {
        int[] codePacket = MatrixTools.setToArray(temp);
        for (int i = 0; i < MPEM.length; i++) {
            int sum = 0;
            for (int j = 0; j < temp.size(); j++) {
                sum += MPEM[i][codePacket[j]];
            }
            if (sum != 1) {
                return false;
            }
            //终止搜索机制
            if (sum == 1 && i == MPEM.length - 1) {
                return true;
            }
        }
        return false;
    }
}
