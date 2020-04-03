package com.appphoto.app.ws.mobileappws.io.repositories;


import com.appphoto.app.ws.mobileappws.io.entity.AddressEntity;
import com.appphoto.app.ws.mobileappws.io.entity.PostEntity;
import com.appphoto.app.ws.mobileappws.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Long>{
  List<PostEntity> findAllByPostOwner(String postOwner);
}
