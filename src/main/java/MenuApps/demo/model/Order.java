package MenuApps.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "master_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="order_date")
    private LocalDateTime order_date;
    @Column(name ="total")
    private BigDecimal total;
    @OneToMany
    @JoinColumn
    private List<Menu> menus;
}
