package com.nanemo.barbershop.service;

import com.nanemo.barbershop.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {
    private AddressRepository addressRepository;

}