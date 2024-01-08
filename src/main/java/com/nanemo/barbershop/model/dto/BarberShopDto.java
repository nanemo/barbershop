package com.nanemo.barbershop.model.dto;

import com.nanemo.barbershop.model.entity.Address;
import com.nanemo.barbershop.model.entity.HairDresser;
import com.nanemo.barbershop.model.entity.Picture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BarberShopDto {
    private Long barberShopId;
    private String barberShopName;
    private Address barberShopAddress;
    private Set<Long> hairDressersId;
    private Set<Long> picturesUrlId;
    private Double latitude;
    private Double longitude;
    private Double radiusInKm;

}
