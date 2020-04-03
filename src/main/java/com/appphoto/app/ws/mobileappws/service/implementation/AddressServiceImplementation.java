package com.appphoto.app.ws.mobileappws.service.implementation;

import com.appphoto.app.ws.mobileappws.io.entity.AddressEntity;
import com.appphoto.app.ws.mobileappws.io.entity.UserEntity;
import com.appphoto.app.ws.mobileappws.io.repositories.AddressRepository;
import com.appphoto.app.ws.mobileappws.io.repositories.UserRepository;
import com.appphoto.app.ws.mobileappws.service.AddressService;
import com.appphoto.app.ws.mobileappws.shared.dto.AddressDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImplementation implements AddressService {
  @Autowired
  UserRepository userRepository;

  @Autowired
  AddressRepository addressRepository;

  @Override
  public List<AddressDto> getAddresses(String userId) {
    List<AddressDto> returnValue = new ArrayList<>();
    ModelMapper modelMapper = new ModelMapper();

    UserEntity userEntity = userRepository.findByUserId(userId);
    if(userEntity==null) return returnValue;

    Iterable<AddressEntity> addresses = addressRepository.findAllByUserDetails(userEntity);
    for(AddressEntity addressEntity: addresses) {
      returnValue.add(modelMapper.map(addressEntity, AddressDto.class));
    }
    return returnValue;
  }

  @Override
  public List<AddressDto> getAddressesFromParam(String userIdParam, String countryParam,String addressIdParam,
                                                String cityParam,String postalParam,
                                                String typeParam) {
    List<AddressDto> returnValue = new ArrayList<>();
    ModelMapper modelMapper = new ModelMapper();

    UserEntity userEntity = userRepository.findByUserId(userIdParam);
    if(userEntity==null) return returnValue;

//    Iterable<AddressEntity> addresses = addressRepository.findAllByUserDetails(userEntity);
    Iterable<AddressEntity> addresses = addressRepository.getAddresses(userEntity,countryParam,addressIdParam,
            cityParam,postalParam, typeParam);

    for(AddressEntity addressEntity: addresses) {
      returnValue.add(modelMapper.map(addressEntity, AddressDto.class));
    }
      return returnValue;
  }

  @Override
  public AddressDto getAddress(String addressId) {
    AddressDto returnValue = null;

    AddressEntity addressEntity = addressRepository.findByAddressId(addressId);

    if(addressEntity!=null){
      returnValue = new ModelMapper().map(addressEntity, AddressDto.class);
    }
    return returnValue;
  }
}
