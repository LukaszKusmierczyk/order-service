package org.klukasz.order.service;

import org.klukasz.order.model.CustomerDTO;
import org.klukasz.order.model.Order;
import org.klukasz.order.model.OrderDTO;
import org.klukasz.order.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final RestTemplate customerService;

    public OrderService(OrderRepository orderRepository, RestTemplate customerService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
    }

    public List<OrderDTO> getOrders() {
        List<OrderDTO> orders = new ArrayList<>();

        for (Order order : orderRepository.findAll()) {
            ResponseEntity<CustomerDTO> customerDTO =
                    customerService.getForEntity("/" + order.getCustomerCode(), CustomerDTO.class);

            String customerName = customerDTO.hasBody() ? customerDTO.getBody().getName() : null;

            orders.add(new OrderDTO(order.getId(), order.getCustomerCode(), customerName, order.getOrderNumber(),
                    order.getOrderDateTime()));
        }

        return orders;
    }
}
