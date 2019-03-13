package com.suda.edu.networkcoding.service.algorithmService;

import com.suda.edu.networkcoding.algorithm.NetworkCode;
import com.suda.edu.networkcoding.service.ComputeTBService;
import com.suda.edu.networkcoding.tools.NetworkCodeTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("hwnerService")
public class HwnerService implements ComputeTBService {

    @Autowired
    @Qualifier("hwner")
    private NetworkCode hwner;

    @Override
    public double computeTB(int number, int packetNumber, int interval, double packetLoss, int times) {
        double bandWith = 0;
        for (int i = 0; i < times; i++) {
            bandWith += NetworkCodeTools.getCommonBandwidth(hwner, number, packetNumber, interval, packetLoss, 0);
        }
        return NetworkCodeTools.computeDivide(bandWith, times);
    }
}
