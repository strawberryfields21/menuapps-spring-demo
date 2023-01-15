package MenuApps.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

@Getter
@Setter
@Entity
@Table(name = "order_detail")
@NoArgsConstructor
public class OrderDetail {
    public OrderDetail(Long orderId, Long menuId) {
        Menu menu1 = new Menu();
        menu1.setId(menuId);

        Order order1 = new Order();
        order1.setId(orderId);
        this.order = order1;
        this.menu = menu1;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    @OneToOne
    @JoinColumn(name = "menu_id")
    @JsonIgnore
    private Menu menu;
}
