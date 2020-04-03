package com.appphoto.app.ws.mobileappws.io.repositories;

import com.appphoto.app.ws.mobileappws.io.entity.AddressEntity;
import com.appphoto.app.ws.mobileappws.io.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Long> {
  List<AddressEntity> findAllByUserDetails(UserEntity userEntity);

  @Query("FROM addresses a WHERE a.userDetails LIKE :userId AND a.country LIKE :country AND a.addressId LIKE " +
          ":addressId AND " +
          "a" +
          ".city LIKE " +
          ":city AND a" +
          ".postalCode LIKE " +
          ":postal AND a.type LIKE :type ")
  List<AddressEntity> getAddresses(@Param("userId") UserEntity userEntity,@Param("country") String countryParam,
                                   @Param("addressId") String addressIdParam,
                                   @Param("city") String cityParam,
                                   @Param("postal") String postalParam,
                                   @Param("type") String typeParam);

  AddressEntity findByAddressId(String addressId);
}
