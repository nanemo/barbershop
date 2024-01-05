package com.nanemo.barbershop.repository;

import com.nanemo.barbershop.model.entity.BarberShop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BarberShopRepository extends JpaRepository<BarberShop, Long> {
    @Query("SELECT b FROM BarberShop b WHERE (:search = '' OR b.barberShopName LIKE %:search%)")
    Page<BarberShop> findFilteredAndSortedProducts(@Param("search") String search, Pageable pageable);

    @Query(value = "SELECT * FROM barber_shops b WHERE earth_distance(ll_to_earth(b.latitude, b.longitude), ll_to_earth(?1, ?2)) < ?3 AND (:search = '' OR b.name LIKE %:search%)", nativeQuery = true)
    Page<BarberShop> findNearbyBarberShops(@Param("userLatitude") double userLatitude, @Param("userLongitude") double userLongitude, @Param("radiusInMeters") double radiusInMeters);


}
