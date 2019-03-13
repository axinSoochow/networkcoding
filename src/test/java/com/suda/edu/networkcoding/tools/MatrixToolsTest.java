package com.suda.edu.networkcoding.tools;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MatrixToolsTest {

    @Test
    public void setToArray() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(6);
        int[] res = MatrixTools.setToArray(set);
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void StringToDataTool() {
        String data = "1.36,1.32,1.3,1.29,1.28,1.27,1.26,1.26,1.25,1.25,1.25,1.25,1.24,1.24,1.24,1.24,1.24,1.23,1.23";
        MatrixTools.StringToData(data);
    }
}