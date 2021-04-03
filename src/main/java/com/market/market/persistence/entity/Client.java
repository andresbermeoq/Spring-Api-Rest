package com.market.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clients")
    private Integer idClients;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private Integer phone;
    private String address;
    private String email;


    @OneToMany(mappedBy = "client")
    private List<Sale> saleList;

    public Integer getIdClients() {
        return idClients;
    }

    public void setIdClients(Integer idClients) {
        this.idClients = idClients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
