package org.klukasz.order.controller;

import org.klukasz.order.model.OrderDTO;
import org.klukasz.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDTO> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("test")
    public String test() {
        return "hurrray";
    }
}
