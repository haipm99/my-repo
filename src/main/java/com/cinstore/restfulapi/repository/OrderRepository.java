package com.cinstore.restfulapi.repository;

import com.cinstore.restfulapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

     Order getOrderByCusNameAndStatus(String id, String status);

     Order getOrderByIdOrder(Long id);


}
