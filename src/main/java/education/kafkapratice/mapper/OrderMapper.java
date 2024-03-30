package education.kafkapratice.mapper;

import education.kafkapratice.config.MapperConfig;
import education.kafkapratice.model.OrderCreateRequestDto;
import education.kafkapratice.dto.OrderResponseDto;
import education.kafkapratice.model.Order;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface OrderMapper {
    OrderResponseDto toDto(Order order);

    Order toBasicModel(OrderCreateRequestDto requestDto);
}
