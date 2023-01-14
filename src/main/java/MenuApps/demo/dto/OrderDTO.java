package MenuApps.demo.dto;

import MenuApps.demo.model.Menu;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

public record OrderDTO(Long id, LocalDateTime date, BigDecimal total, List<Menu> menuList) {
}
