package com.cinstore.restfulapi.dto;

public class OrderDetailDTO {
    private String cusName;
    private String idProduct;
    private int quantity;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String cusName, String idProduct, int quantity) {
        this.cusName = cusName;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
