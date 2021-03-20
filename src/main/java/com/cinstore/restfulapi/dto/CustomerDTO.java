package com.cinstore.restfulapi.dto;

public class CustomerDTO {

    private String idCustomer;
    private String password;
    private String noPhone;
    private String address;

    public CustomerDTO(){
    }

    public CustomerDTO(String idCustomer, String password, String noPhone, String address) {
        this.idCustomer = idCustomer;
        this.password = password;
        this.noPhone = noPhone;
        this.address = address;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNoPhone() {
        return noPhone;
    }

    public void setNoPhone(String noPhone) {
        this.noPhone = noPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
