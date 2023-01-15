package MenuApps.demo.service;

import MenuApps.demo.dto.OrderDetailMenuDTO;
import MenuApps.demo.model.Menu;
import MenuApps.demo.model.Order;
import MenuApps.demo.model.OrderDetail;
import MenuApps.demo.model.OrderPrice;
import MenuApps.demo.repository.CategoryRepository;
import MenuApps.demo.repository.MenuRepository;
import MenuApps.demo.repository.OrderDetailRepository;
import MenuApps.demo.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackOn = Exception.class)
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    MenuRepository menuRepository;

    @Override
    public Order createWithOrder(List<Long> menu_id) {
        BigDecimal total = new BigDecimal(0.0);
        Order newData = new Order();
        newData.setOrder_date(LocalDateTime.now());
        for (int i = 0; i < menu_id.size(); i++) {
            Optional<Menu> menus = Optional.of(new Menu());
            menus =  menuRepository.findById(menu_id.get(i));
            total = total.add(menus.get().getPrice());
        }
        newData.setTotal(total);
        Order var = orderRepository.save(newData);
        List<OrderDetail> orderDetails = menu_id.stream().map(aLong -> new OrderDetail(var.getId(), aLong)).toList();
        orderDetailRepository.saveAll(orderDetails);
        return null;
    }

    @Override
    public List<OrderDetailMenuDTO> getDetail(Long order_id) {
        return  orderRepository.GetOrder(order_id);
    }

    @Override
    public Order GetById(Long id) {
        return  orderRepository.GetOrderById(id);
    }
}
