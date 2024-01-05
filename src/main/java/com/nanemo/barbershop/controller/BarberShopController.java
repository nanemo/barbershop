package com.nanemo.barbershop.controller;

import com.nanemo.barbershop.model.entity.BarberShop;
import com.nanemo.barbershop.service.BarberShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class BarberShopController {
    private final BarberShopService barberShopService;

    @GetMapping
    public ResponseEntity<Page<BarberShop>> findAllBarberShops(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "barbershopId") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder)
    {
        Page<BarberShop> page = barberShopService.findAllBarberShops(search, pageNumber, pageSize, sortBy, sortOrder);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/nearby-barbershop")
    public Set<BarberShop> nearbyBarberShop(
            @RequestParam(defaultValue = "") Double latitude,
            @RequestParam(defaultValue = "") Double longitude,
            @RequestParam(defaultValue = "") Double radiusInKm,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "barbershopId") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder)
    {
        Page<BarberShop> page = barberShopService.nearbyBarberShop(latitude, longitude, radiusInKm, pageNumber, pageSize, sortBy, sortOrder);
        return null;
    }

}