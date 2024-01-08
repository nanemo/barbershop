package com.nanemo.barbershop.model.map;

import com.nanemo.barbershop.model.dto.BarberShopDto;
import com.nanemo.barbershop.model.entity.BarberShop;
import com.nanemo.barbershop.model.entity.HairDresser;
import com.nanemo.barbershop.model.entity.Picture;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BarberShopMapper {

    @Mapping(target = "hairDressersId", expression = "java(this::hairDressersToHairDressersId)")
    @Mapping(target = "picturesUrlId", expression = "java(this::picturesUrlToPicturesUrlId)")
    BarberShopDto toBarberShopDto(BarberShop barberShop);
    default Page<BarberShopDto> toPageBarberShopDto(Page<BarberShop> barberShop) {
        List<BarberShopDto> dtoList = barberShop.getContent().stream()
                .map(this::toBarberShopDto).collect(Collectors.toList());
        return new PageImpl<>(dtoList, barberShop.getPageable(), barberShop.getTotalElements());
    }

    default Set<Long> hairDressersToHairDressersId(Set<HairDresser> hairDressers){
        return hairDressers.stream().map(HairDresser::getHairDresserId).collect(Collectors.toSet());
    }

    default Set<Long> picturesUrlToPicturesUrlId(Set<Picture> pictures) {
        return pictures.stream().map(Picture::getPictureId).collect(Collectors.toSet());
    }
}
