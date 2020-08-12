package io.kubeless;

import io.kubeless.Event;
import io.kubeless.Context;

import org.joda.time.LocalTime;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Hello {
    public String sayHello(io.kubeless.Event event, io.kubeless.Context context) {
		Properties properties = new Properties();
        properties.put("bootstrap.servers", "192.168.1.20:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);
        try{
            for(int i = 0; i < 100; i++){
                System.out.println(i);
                kafkaProducer.send(new ProducerRecord<String, String>("TutorialTopicExterno", Integer.toString(i), "test message - " + i ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            kafkaProducer.close();
        }
        System.out.println(event.Data);
        LocalTime currentTime = new LocalTime();
        return "Hello world! Current local time is: " + currentTime;
    }
}





public class Producer {

    public static void main(String[] args){
        
    }
}