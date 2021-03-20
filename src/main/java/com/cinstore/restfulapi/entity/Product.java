package com.cinstore.restfulapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @Column(name = "Id_Product")
    private String id;
    @Column(name = "Image_Product")
    private String image;
    @Column(name = "Name_Product")
    private String name;
    @Column(name = "Price_Product")
    private float price;
    @Column(name = "Quantity")
    private int quantity;
    @Column(name = "Status")
    private String stat;
}
