package education.kafkapratice.kafka;

import education.kafkapratice.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsoleOrderConsumer  {
    @KafkaListener(topics = "send-order-event", groupId = "console-order-group",
            containerFactory = "kafkaListenerContainerFactory")
    public void consume(Order order) {
        System.out.println("Received order in console consumer: " + order);
    }
}
