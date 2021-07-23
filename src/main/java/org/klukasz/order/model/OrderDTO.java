package org.klukasz.order.model;

import java.time.LocalDateTime;

public class OrderDTO {
    private Long id;
    private String customerCode;
    private String customerName;
    private String orderNumber;
    private LocalDateTime orderDateTime;

    public OrderDTO() {

    }

    public OrderDTO(Long id, String customerCode, String customerName, String orderNumber,
                    LocalDateTime orderDateTime) {
        this.id = id;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.orderNumber = orderNumber;
        this.orderDateTime = orderDateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
