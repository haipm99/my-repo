package com.cinstore.restfulapi.service;

import com.cinstore.restfulapi.entity.Order;
import com.cinstore.restfulapi.entity.OrderDetails;
import com.cinstore.restfulapi.repository.OrderDetailsRepository;
import com.cinstore.restfulapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public OrderDetails saveOrderDetail(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    public Order getOrderByCusNameAndStatus(String id, String status) {
        return orderRepository.getOrderByCusNameAndStatus(id, status);
    }

    public Order getOrderByIdOrder(Long id) {
        return orderRepository.getOrderByIdOrder(id);
    }

    public OrderDetails getOrderDetailsByIdOrderAndIdProduct(Long idOrder, String idProduct) {
        return orderDetailsRepository.getOrderDetailsByIdOrderAndIdProduct(idOrder, idProduct);
    }


//    public Order checkCustomerCart(String id, String status) {
//        return orderRepository.findOrderByCusNameAndStatus(id, status);
//    }

//    public List<Order> getAllOrder(String id) {
//        return orderRepository.getAllByCusName(id);
//    }

    public List<OrderDetails> getAllOrderDetail(Long id) {
        return orderDetailsRepository.getAllByIdOrder(id);
    }

    public void saveAll(List<OrderDetails> orderDetailsList) {
        orderDetailsRepository.saveAll(orderDetailsList);
    }

}
