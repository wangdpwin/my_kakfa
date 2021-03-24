package cn.wangdpwin.my_kafka.interceptor;

import java.util.Map;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;

/**
 * @Author: wangdongpeng
 * @Date: 2020-09-10 18:59
 * @Description
 * @Version 1.0
 */
public class AvgLatencyProducerInterceptor implements ProducerInterceptor<String, String> {

    @Autowired
    private Jedis jedis;


    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
//        jedis.incr("totalSentMessage");
        return record;
    }


    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
    }


    @Override
    public void close() {
    }


    @Override
    public void configure(Map<String, ?> configs) {
    }

}