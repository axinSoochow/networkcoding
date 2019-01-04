package com.suda.edu.networkcoding.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AxinController {

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

    @RequestMapping("/run")
    public String run() {

        return "程序运行成功！";
    }
}







