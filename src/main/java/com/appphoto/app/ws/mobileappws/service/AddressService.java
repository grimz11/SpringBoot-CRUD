package com.appphoto.app.ws.mobileappws.service;

import com.appphoto.app.ws.mobileappws.shared.dto.AddressDto;

import java.util.List;

public interface AddressService {
  List<AddressDto> getAddresses(String userId);
  List<AddressDto> getAddressesFromParam(String userIdParam, String countryParam, String addressIdParam,
                                         String cityParam,
                                         String postalParam, String typeParam);
  AddressDto getAddress(String addressId);
}
