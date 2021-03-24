package cn.wangdpwin.my_kafka.kafka;

import java.util.List;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author: wangdongpeng
 * @Date: 2020-09-03 19:31
 * @Description
 * @Version 1.0
 */
@Component
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * 向topic中发送消息
     */
    public void send (String topic, String msg) {
        kafkaTemplate.send(topic, msg);
    }

    /**
     * 向topic中发送消息
     */
    public void send (String topic, List<String> msgs) {
        msgs.forEach(msg -> kafkaTemplate.send(topic, msg));
    }
}