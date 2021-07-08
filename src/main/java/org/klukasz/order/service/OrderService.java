package org.klukasz.order.service;

import org.klukasz.order.model.Order;
import org.klukasz.order.model.OrderDTO;
import org.klukasz.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> getOrders() {
        List<OrderDTO> orders = new ArrayList<>();

        for (Order order : orderRepository.findAll()) {
            orders.add(new OrderDTO(order.getId(), order.getCustomerCode(), order.getOrderNumber(), order.getOrderDateTime()));
        }

        return orders;
    }
}
