package cn.wangdpwin.my_kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: wangdongpeng
 * @Date: 2020-09-03 19:28
 * @Description 测试kafka批量消费消息
 * 参考代码 https://my.oschina.net/tianshl/blog/2051313
 * @Version 1.0
 */
@EnableScheduling
@SpringBootApplication
public class MyKafkaApp {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MyKafkaApp.class);
        application.run();
    }

}