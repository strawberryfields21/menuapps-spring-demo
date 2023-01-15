package MenuApps.demo.controller;

import MenuApps.demo.dto.OrderDTO;
import MenuApps.demo.dto.OrderDetailMenuDTO;
import MenuApps.demo.model.Menu;
import MenuApps.demo.model.Order;
import MenuApps.demo.model.OrderDetail;
import MenuApps.demo.model.OrderPrice;
import MenuApps.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> getAll(@RequestBody OrderDTO request){
        orderService.createWithOrder(request.menus());
        return new ResponseEntity<>("TEST", HttpStatus.OK);
    }
    @GetMapping("/order_detail/{id}")
    public List<OrderDetailMenuDTO> getOrderDetail(@PathVariable Long id){
        return orderService.getDetail(id);
    }
    @GetMapping("get_by_id/{id}")
    public Order getById(@PathVariable Long id){
        return orderService.GetById(id);
    }
}
