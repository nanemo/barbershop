package com.nanemo.barbershop.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "hair_dresser")
public class HairDresser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hairdresser_id")
    private Long hairDresserId;

    @ManyToOne
    @JoinColumn(name = "barber_shop_id")
    private BarberShop barberShop;
}