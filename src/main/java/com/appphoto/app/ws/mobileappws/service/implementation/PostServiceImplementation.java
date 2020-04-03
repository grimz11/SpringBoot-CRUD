package com.appphoto.app.ws.mobileappws.service.implementation;

import com.appphoto.app.ws.mobileappws.SpringApplicationContext;
import com.appphoto.app.ws.mobileappws.io.entity.PostEntity;
import com.appphoto.app.ws.mobileappws.io.entity.UserEntity;
import com.appphoto.app.ws.mobileappws.io.repositories.PostRepository;
import com.appphoto.app.ws.mobileappws.service.PostService;
import com.appphoto.app.ws.mobileappws.service.UserService;
import com.appphoto.app.ws.mobileappws.shared.Utils;
import com.appphoto.app.ws.mobileappws.shared.dto.PostDto;
import com.appphoto.app.ws.mobileappws.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PostServiceImplementation implements PostService {
  @Autowired
  PostRepository postRepository;

  @Autowired
  Utils utils;

  @Override
  public PostDto createPost(PostDto post) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    UserService userService = (UserService) SpringApplicationContext.getBean("userServiceImplementation");
    UserDto userDto = userService.getUser(auth.getName());

    ModelMapper modelMapper = new ModelMapper();

    PostEntity postEntity = modelMapper.map(post, PostEntity.class);
    String postPublicId = utils.generatePostId(30);
    postEntity.setPostId(postPublicId);
    postEntity.setPostOwner(userDto.getUserId());

    PostEntity storedPostDetails = postRepository.save(postEntity);
    PostDto returnValue = modelMapper.map(storedPostDetails, PostDto.class);

    return returnValue;
  }

  @Override
  public List<PostDto> getPost(String postOwner) {
    List<PostDto> returnValue = new ArrayList<>();
    List<PostEntity> posts = postRepository.findAllByPostOwner(postOwner);
    ModelMapper modelMapper = new ModelMapper();

    for (PostEntity postEntity: posts) {
      PostDto postDto = new PostDto();
      modelMapper.map(postEntity, postDto);
      returnValue.add(postDto);
    }
    return returnValue;
  }
}
