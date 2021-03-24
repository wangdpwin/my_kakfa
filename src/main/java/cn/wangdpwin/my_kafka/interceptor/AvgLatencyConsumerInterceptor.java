package cn.wangdpwin.my_kafka.my_kafka.interceptor;

import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;

/**
 * @Author: wangdongpeng
 * @Date: 2020-09-10 19:00
 * @Description
 * @Version 1.0
 */
public class AvgLatencyConsumerInterceptor implements ConsumerInterceptor<String, String> {

    @Autowired
    private Jedis jedis;


    @Override
    public ConsumerRecords<String, String> onConsume(ConsumerRecords<String, String> records) {
        long lantency = 0L;
        for (ConsumerRecord<String, String> record : records) {
            lantency += (System.currentTimeMillis() - record.timestamp());
        }
//        jedis.incrBy("totalLatency", lantency);
//        long totalLatency = Long.parseLong(jedis.get("totalLatency"));
//        long totalSentMsgs = Long.parseLong(jedis.get("totalSentMessage"));
//        jedis.set("avgLatency", String.valueOf(totalLatency / totalSentMsgs));
        return records;
    }


    @Override
    public void onCommit(Map<TopicPartition, OffsetAndMetadata> offsets) {
    }


    @Override
    public void close() {
    }


    @Override
    public void configure(Map<String, ?> configs) {
    }

}