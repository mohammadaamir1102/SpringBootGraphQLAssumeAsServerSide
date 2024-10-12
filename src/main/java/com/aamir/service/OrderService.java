package com.aamir.service;

import com.aamir.entity.Order;
import com.aamir.exception.ExceptionHandler;
import com.aamir.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int orderId) {
        return orderRepository.findById(orderId).orElseThrow(ExceptionHandler::throwResourceNotFoundException);
    }

    public boolean deleteOrderById(int orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(ExceptionHandler::throwResourceNotFoundException);
        orderRepository.delete(order);
        return true;
    }
}
