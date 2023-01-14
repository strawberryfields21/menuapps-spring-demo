package MenuApps.demo.dto;

import java.math.BigDecimal;

public record MenuDTO(Long id, String name, String description, BigDecimal price) {
}
