package com.appphoto.app.ws.mobileappws.service;

import com.appphoto.app.ws.mobileappws.shared.dto.AddressDto;

import java.util.List;

public interface AddressService {
  List<AddressDto> getAddresses(String userId);
  AddressDto getAddress(String addressId);
}
