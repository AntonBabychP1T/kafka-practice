package education.kafkapratice.dto;

import java.math.BigDecimal;

public record OrderResponseDto(
        Long id,
        Integer quantity,
        BigDecimal price,
        Long productId
) {
}
