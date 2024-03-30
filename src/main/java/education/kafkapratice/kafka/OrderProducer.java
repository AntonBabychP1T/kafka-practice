package education.kafkapratice.kafka;

import education.kafkapratice.model.OrderCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderProducer {
    private static final String TOPIC = "send-order-event";

    private final KafkaTemplate<String, OrderCreateRequestDto> kafkaTemplate;

    public void sendMessage(OrderCreateRequestDto requestDto) {
        kafkaTemplate.send(TOPIC, requestDto);
    }
}
