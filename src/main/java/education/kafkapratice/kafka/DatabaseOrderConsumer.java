package education.kafkapratice.kafka;

import education.kafkapratice.model.Order;
import education.kafkapratice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DatabaseOrderConsumer   {
    private final OrderRepository orderRepository;

    @KafkaListener(topics = "send-order-event", groupId = "db-order-group",
            containerFactory = "kafkaListenerContainerFactory")
    public void consume(Order order) {
        orderRepository.save(order);
        System.out.println("Received order in database consumer: " + order);
    }
}
