package cn.wangdpwin.my_kafka.jobs;

import cn.wangdpwin.my_kafka.kafka.KafkaProducer;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: wangdongpeng
 * @Date: 2020-09-11 18:51
 * @Description
 * @Version 1.0
 */
//@Component
public class ProducerJob {

    private Logger log = LoggerFactory.getLogger(ProducerJob.class);

    @Autowired
    private KafkaProducer kafkaProducer;

//    @Scheduled(cron = "0/5 * * * * ?")
    public void pushDataScheduled(){
        log.info("start send msg");
        Stream.of(1,2,3,4,5).forEach(i -> {
            kafkaProducer.send("web", i.toString());
        });
    }

}