package com.cinstore.restfulapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDER_DETAIL")
public class OrderDetails {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "Id_Order_Details", nullable = false)
    private Long Id_Order_Details;
    @Column(name = "Id_Order")
    private Long idOrder;
    @Column(name = "Id_Product")
    private String idProduct;
    @Column(name = "Quantity")
    private Integer quantity;
    @Column(name = "Status")
    private String status;

}
