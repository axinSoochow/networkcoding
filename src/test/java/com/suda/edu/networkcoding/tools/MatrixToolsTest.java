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
}