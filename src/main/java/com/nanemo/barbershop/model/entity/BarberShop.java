package com.nanemo.barbershop.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "barbershops")
public class BarberShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "barbershop_id")
    private Long barberShopId;

    @Column(name = "barbershop_name")
    private String barberShopName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address barberShopAddress;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "barberShop")
    private Set<HairDresser> hairDressers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "barberShop")
    private Set<Picture> picturesUrl;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "radius_km_in")
    private Double radiusInKm;

}
