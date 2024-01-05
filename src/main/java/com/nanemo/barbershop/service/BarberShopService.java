package com.nanemo.barbershop.service;

import com.nanemo.barbershop.model.entity.BarberShop;
import com.nanemo.barbershop.repository.BarberShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BarberShopService {
    private final BarberShopRepository barberShopRepository;

    public Page<BarberShop> findAllBarberShops(String search, int pageNumber, int pageSize, String sortBy, String sortOrder) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortBy);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return barberShopRepository.findFilteredAndSortedProducts(search, pageable);
    }

    public Page<BarberShop> nearbyBarberShop(Double latitude, Double longitude, Double radiusInKm, int pageNumber,
                                             int pageSize, String sortBy, String sortOrder) {

        return null;
    }
}
