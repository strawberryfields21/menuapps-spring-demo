package MenuApps.demo.repository;

import MenuApps.demo.dto.OrderDetailMenuDTO;
import MenuApps.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
@Query(value = "SELECT new MenuApps.demo.dto.OrderDetailMenuDTO(master_order.order_date,master_menu.name,master_menu.price) FROM master_order INNER JOIN order_detail ON order_detail.order_id = master_order.id INNER JOIN master_menu ON master_menu.id= order_detail.menu_id WHERE master_order.id = ?1 GROUP BY master_order.order_date,master_menu.name ,master_menu.price",nativeQuery = true)
    List<OrderDetailMenuDTO> GetOrder(Long id);
@Query(value = "SELECT * FROM master_order WHERE id = ?",nativeQuery = true)
    Order GetOrderById(long id);
}
