package MenuApps.demo.dto;

import MenuApps.demo.model.Category;

import java.math.BigDecimal;

public record MenuDTO(Long id, String name, String description, BigDecimal price,Long category) {
}
