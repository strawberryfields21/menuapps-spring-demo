package MenuApps.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailMenuDTO {

    private Long id;
    private LocalDateTime order_date;
    private String name;
    private BigDecimal price;
}
