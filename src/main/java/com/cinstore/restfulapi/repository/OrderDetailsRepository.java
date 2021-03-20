package com.cinstore.restfulapi.repository;

import com.cinstore.restfulapi.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

    List<OrderDetails> getAllByIdOrder(Long idOrder);

    @Override
    <S extends OrderDetails> List<S> saveAll(Iterable<S> entities);

    OrderDetails getOrderDetailsByIdOrderAndIdProduct(Long idOrder, String idProduct);
}
