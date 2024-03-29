package education.kafkapratice.kafka;

import education.kafkapratice.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderProducer {
    private static final String TOPIC = "send-order-event";

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public void sendMessage(Order order) {
        kafkaTemplate.send(TOPIC, order);
    }
}
