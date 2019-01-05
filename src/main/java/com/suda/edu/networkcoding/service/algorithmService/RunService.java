package com.suda.edu.networkcoding.service.algorithmService;

import com.alibaba.fastjson.JSON;
import com.suda.edu.networkcoding.service.ComputeTBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RunService {


    @Autowired
    @Qualifier("arqService")
    private ComputeTBService arqService;

    @Autowired
    @Qualifier("cdncwmrService")
    private ComputeTBService cdncwmrService;

    /**
     * 接收端数量变化时
     * 计算无编码冲突的即使网络编码性能图
     *
     * @param number
     * @param packetNumber
     * @param interval
     * @param packetLoss
     * @param times
     */
    public void computePerformanceWithNumberChange(int number, int packetNumber, int interval, double packetLoss, int times) {

        //0.x轴
        List<Double> axis = new ArrayList<>();

        List<Double> arqData = new ArrayList<>();
        List<Double> cdncwmrData = new ArrayList<>();

        for (int i = 2; i <= 12; i++) {
            axis.add(new Double(i));
            arqData.add(arqService.computeTB(i, packetNumber, interval, packetLoss, times));
            cdncwmrData.add(cdncwmrService.computeTB(i, packetNumber, interval, packetLoss, times));
        }


        log.info("\n" +
                        "X轴数值为{}\n" +
                        "arq数据为{}\n" +
                        "cdncwmr数据为{}\n"
                , JSON.toJSONString(axis)
                , JSON.toJSONString(arqData)
                , JSON.toJSONString(cdncwmrData));
    }

    /**
     * 接收链路丢包率变化时
     * 计算无编码冲突的即使网络编码性能图
     *
     * @param number
     * @param packetNumber
     * @param interval
     * @param packetLoss
     * @param times
     */
    public void computePerformanceWithPacketLossChange(int number, int packetNumber, int interval, double packetLoss, int times) {

        //0.x轴
        List<Double> axis = new ArrayList<>();

        List<Double> arqData = new ArrayList<>();
        List<Double> cdncwmrData = new ArrayList<>();

        for (double i = 5; i <= 35; i += 5) {

            //处理double类型的链路丢包率
            packetLoss = new BigDecimal(new Double(i)).divide(new BigDecimal(100)).doubleValue();
            axis.add(packetLoss);
            arqData.add(arqService.computeTB(number, packetNumber, interval, packetLoss, times));
            cdncwmrData.add(cdncwmrService.computeTB(number, packetNumber, interval, packetLoss, times));
        }

        log.info("\n" +
                        "X轴数值为{}\n" +
                        "arq数据为{}\n" +
                        "cdncwmr数据为{}\n"
                , JSON.toJSONString(axis)
                , JSON.toJSONString(arqData)
                , JSON.toJSONString(cdncwmrData));

    }

    /**
     * 重传时间间隔变化时
     * 计算无编码冲突的即使网络编码性能图
     *
     *  @param number
     * @param packetNumber
     * @param interval
     * @param packetLoss
     * @param times
     */
    public void computePerformanceWithIntervalChange(int number, int packetNumber, int interval, double packetLoss, int times) {

        //0.x轴
        List<Double> axis = new ArrayList<>();
        List<Double> cdncwmrData = new ArrayList<>();

        for (int i = 10; i <= 100; i+=10) {
            axis.add(new Double(i));
            cdncwmrData.add(cdncwmrService.computeTB(number, packetNumber, i, packetLoss, times));
        }

        log.info("\n" +
                        "X轴数值为{}\n" +
                        "cdncwmr数据为{}\n"
                , JSON.toJSONString(axis)
                , JSON.toJSONString(cdncwmrData));
    }
}
