package com.nanemo.barbershop.repository;

import com.nanemo.barbershop.model.entity.Address;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByAddressIdInOrderByAddressIdDescBarberShopAsc(@Param("addressId") Set<Long> addressId);

    void findByAddressIdInOffsetAndLimit(Set<Long> longs, int i, int i1);


    List<Address> findByAddressIdInOffsetAndLimit(Set<Long> addressId, Pageable pageable);
}
