package education.kafkapratice.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record OrderCreateRequestDto(
        @NotNull @Min(0) Integer quantity,
        @NotNull @Min(0) Long productId
) {
}
