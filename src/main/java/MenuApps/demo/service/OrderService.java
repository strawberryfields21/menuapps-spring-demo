package MenuApps.demo.service;

import MenuApps.demo.dto.OrderDetailMenuDTO;
import MenuApps.demo.model.Menu;
import MenuApps.demo.model.Order;
import MenuApps.demo.model.OrderDetail;
import MenuApps.demo.model.OrderPrice;

import java.util.List;

public interface OrderService {
    Order createWithOrder (List<Long> menu_id);
    List<OrderDetailMenuDTO> getDetail(Long order_id);

    Order GetById(Long id);

}
