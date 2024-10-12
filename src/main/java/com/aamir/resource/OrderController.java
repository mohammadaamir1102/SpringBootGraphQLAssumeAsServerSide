package com.aamir.resource;

import com.aamir.dto.OrderInput;
import com.aamir.entity.Order;
import com.aamir.entity.User;
import com.aamir.service.OrderService;
import com.aamir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @MutationMapping
    public Order createOrder(@Argument String orderDetails, @Argument String address, @Argument int price, @Argument int userId) {
        User user = userService.getUserById(userId);
        Order order = new Order();
        order.setOrderDetails(orderDetails);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(user);

        return orderService.createOrder(order);
    }

    @MutationMapping
    public Order createOrderBySecondWay(@Argument OrderInput orderInput, @Argument int userId) {
        User user = userService.getUserById(userId);
        Order order = new Order();
        order.setOrderDetails(orderInput.getOrderDetails());
        order.setAddress(orderInput.getAddress());
        order.setPrice(order.getPrice());
        order.setUser(user);

        return orderService.createOrder(order);
    }

    @QueryMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
    @QueryMapping
    public Order getOrderById(@Argument int orderId){
        return orderService.getOrderById(orderId);
    }

    @MutationMapping
    public boolean deleteOrderById(@Argument int orderId){
        return orderService.deleteOrderById(orderId);
    }
}
