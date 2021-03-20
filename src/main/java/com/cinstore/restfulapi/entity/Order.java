package com.cinstore.restfulapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "Id_Order", nullable = false)
    private Long idOrder;
    @Column(name = "un_Customer")
    private String cusName;
    @Column(name = "total_Quantity")
    private int quantityTotal;
    @Column(name = "total_Price")
    private float priceTotal;
    @Column(name = "Status")
    private String status;


}
