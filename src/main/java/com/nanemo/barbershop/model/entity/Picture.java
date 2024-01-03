package com.nanemo.barbershop.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pictures")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "picture_id")
    private Long pictureId;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name = "picture_size")
    private Integer pictureSize;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barberShopId")
    private BarberShop barberShop;

    @Column(name = "is_cover_picture")
    private Boolean isCoverPicture;
}
