package com.suda.edu.networkcoding.algorithm;

import com.suda.edu.networkcoding.NetworkcodingApplicationTests;
import com.suda.edu.networkcoding.tools.MatrixTools;
import com.suda.edu.networkcoding.tools.NetworkCodeTools;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Arrays;

public class CdNcwmrTest extends NetworkcodingApplicationTests {

    @Autowired
    @Qualifier("cdncwbr")
    private NetworkCode cdncwmr;

    @Test
    public void getCodePacket() {
        int[][] MPEM = NetworkCodeTools.creatMPEM(5, 15, 0.3);

        MatrixTools.printMatrix(MPEM);

        int[] codePacket = cdncwmr.getCodePacket(MPEM);

        System.out.println(Arrays.toString(codePacket));
    }


}