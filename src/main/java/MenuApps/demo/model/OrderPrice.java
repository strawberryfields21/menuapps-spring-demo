package MenuApps.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class OrderPrice {
    private LocalDateTime order_date;
    private String name;
    private BigDecimal price;

}
