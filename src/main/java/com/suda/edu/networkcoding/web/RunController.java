package com.suda.edu.networkcoding.web;

import com.suda.edu.networkcoding.service.algorithmService.RunService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RunController {

    @Value("${networkcode.number}")
    private int number;

    @Value("${networkcode.packetNumber}")
    private int packetNumber;

    @Value("${networkcode.interval}")
    private int interval;

    @Value("${networkcode.packetLoss}")
    private double packetLoss;

    @Value("${networkcode.times}")
    private int times;

    @Autowired
    private RunService runService;

    @RequestMapping("/run")
    public String run1() {
        runService.computePerformanceWithNumberChange(number, packetNumber, interval, packetLoss, times);
        runService.computePerformanceWithPacketLossChange(number, packetNumber, interval, packetLoss, times);
        runService.computePerformanceWithIntervalChange(number, packetNumber, interval, packetLoss, times);
        return "程序运行成功！";
    }
}







