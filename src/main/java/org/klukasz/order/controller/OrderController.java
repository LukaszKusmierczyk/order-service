package org.klukasz.order.controller;

import org.klukasz.order.model.OrderDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping
    public List<OrderDTO> getOrders() {
        List<OrderDTO> orders = new ArrayList<>();
        orders.add(new OrderDTO(1L, "COCA-COLA", "ON-12345", LocalDateTime.now()));

        return orders;
    }
}
