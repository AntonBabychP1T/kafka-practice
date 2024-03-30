package education.kafkapratice.service;

import education.kafkapratice.model.OrderCreateRequestDto;
import java.util.List;
import education.kafkapratice.dto.OrderResponseDto;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    OrderResponseDto createOrder(OrderCreateRequestDto requestDto);

    List<OrderResponseDto> getAllOrder(Pageable pageable);
}
