package com.cinstore.restfulapi.controller;


import com.cinstore.restfulapi.dto.OrderDetailDTO;
import com.cinstore.restfulapi.entity.Order;
import com.cinstore.restfulapi.entity.OrderDetails;
import com.cinstore.restfulapi.entity.Product;
import com.cinstore.restfulapi.service.OrderService;
import com.cinstore.restfulapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private ProductService productService;

    //add and create new cart
    @PostMapping("/order")
    public String Order(@RequestBody OrderDetailDTO orderDetailDTO) {
       Order order = service.getOrderByCusNameAndStatus(orderDetailDTO.getCusName(), "pending");

        if (order == null) {
            order = new Order();
            order.setCusName(orderDetailDTO.getCusName());
            order.setStatus("pending");

            service.saveOrder(order);
        }
        OrderDetails orderDetail  = service.getOrderDetailsByIdOrderAndIdProduct(order.getIdOrder(), orderDetailDTO.getIdProduct());

        if(orderDetail != null) {
            orderDetail.setQuantity(orderDetailDTO.getQuantity()+orderDetail.getQuantity());
            service.saveOrderDetail(orderDetail);
        }else {
            OrderDetails orderDetails = new OrderDetails(null,order.getIdOrder(), orderDetailDTO.getIdProduct(), orderDetailDTO.getQuantity(), "pending");
            service.saveOrderDetail(orderDetails);
        }

        return "Success";
    }

    //order product
    @PutMapping("/confirmOrder")
    public String confirmOrder(@RequestBody OrderDetailDTO orderDetailDTO) {
        Order order = service.getOrderByCusNameAndStatus(orderDetailDTO.getCusName(), "pending");
        Product product = null;
        order.setStatus("Success");
        service.saveOrder(order);
        float priceTotal = 0;
        int quantityTotal = 0;

        List<OrderDetails> orderDetailsList = service.getAllOrderDetail(order.getIdOrder());
        for (OrderDetails orderDetails: orderDetailsList) {

            product = productService.getProductsById(orderDetails.getIdProduct());
            int quantityProduct = orderDetails.getQuantity();
            float priceProduct = product.getPrice();
            quantityTotal += quantityProduct;
            priceTotal += (quantityProduct*priceProduct);
            orderDetails.setStatus("Success");
        }
        order.setQuantityTotal(quantityTotal);
        order.setPriceTotal(priceTotal);
        service.saveAll(orderDetailsList);

        return "Success";
    }

    //deleted product in cart
    @GetMapping("/deleteCart/{idOrder}/productsDelete/{idProduct}")
    public String deleteCart(@PathVariable Long idOrder, @PathVariable String idProduct) {
        Order order = service.getOrderByIdOrder(idOrder);
        OrderDetails orderDetails = service.getOrderDetailsByIdOrderAndIdProduct(idOrder, idProduct);

        order.setStatus("Deleted");
        orderDetails.setStatus("Deleted");

        service.saveOrder(order);
        service.saveOrderDetail(orderDetails);

        return "Success";
    }

}
