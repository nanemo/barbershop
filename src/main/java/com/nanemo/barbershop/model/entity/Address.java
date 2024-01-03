package com.nanemo.barbershop.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @OneToOne(mappedBy = "barberShopAddress")
    private BarberShop barberShop;
}
