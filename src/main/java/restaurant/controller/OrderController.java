package restaurant.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import restaurant.model.Order;
import restaurant.service.OrderService;

import java.util.concurrent.BlockingQueue;

@Slf4j
@RestController
@RequestMapping(value = "/restaurant")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/orders")
    public void placeOrder(@RequestBody Order order) {
        orderService.placeOrder(order);
    }

    @GetMapping("/orders")
    public BlockingQueue<Order> getPreparedOrders() {
        BlockingQueue<Order> preparedOrders = orderService.getPreparedOrders();
        log.info("preparedOrders size: " + preparedOrders.size());
        return orderService.getPreparedOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getPreparedOrder() {
        return orderService.getPreparedOrder();
    }

}
