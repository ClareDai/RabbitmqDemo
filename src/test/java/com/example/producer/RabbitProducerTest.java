package com.example.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitProducerTest {

    @Autowired
    private RabbitProducer producer;

    @Test
    public void queueSend() {
        for (int i = 0; i < 5; i++) {
            producer.queueSend();
            try {
                //停顿1秒
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void fanoutSend() {
        producer.fanoutSend();
    }

    @Test
    public void testTopic() {
        producer.topicTopic1Send();
        producer.topicTopic2Send();
        producer.topicTopic3Send();
    }
}