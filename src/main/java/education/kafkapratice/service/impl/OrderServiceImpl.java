package education.kafkapratice.service.impl;

import education.kafkapratice.model.OrderCreateRequestDto;
import education.kafkapratice.dto.OrderResponseDto;
import education.kafkapratice.model.ProductResponseDto;
import education.kafkapratice.mapper.OrderMapper;
import education.kafkapratice.model.Order;
import education.kafkapratice.repository.OrderRepository;
import education.kafkapratice.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private static final String REQUEST_TOPIC = "request-product-info";
    private static final String RESPONSE_TOPIC = "response-product-info";

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final KafkaTemplate<String, Long> kafkaTemplate;

    @KafkaListener(topics = "send-order-event", groupId = "db-order-group",
            containerFactory = "kafkaListenerContainerFactory")
    @Override
    public OrderResponseDto createOrder(OrderCreateRequestDto requestDto) {
        Order order = orderMapper.toBasicModel(requestDto);
        requestProductInfo(requestDto.productId());
        return null;
    }

    @Override
    public List<OrderResponseDto> getAllOrder(Pageable pageable) {
        return orderRepository.findAll(pageable).stream()
                .map(orderMapper::toDto)
                .toList();
    }

    private void requestProductInfo(Long productId) {
        kafkaTemplate.send(REQUEST_TOPIC, productId);
    }

    @KafkaListener(topics = RESPONSE_TOPIC, groupId = "response-group", containerFactory = "kafkaListenerContainerFactory")
    public void receiveProductInfo(ProductResponseDto response) {
        System.out.println("product received: " + response);
        // обробка отриманої інформації про продукт
    }
}
