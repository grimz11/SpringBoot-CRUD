package com.appphoto.app.ws.mobileappws.controller;

import com.appphoto.app.ws.mobileappws.SpringApplicationContext;
import com.appphoto.app.ws.mobileappws.service.PostService;
import com.appphoto.app.ws.mobileappws.service.UserService;
import com.appphoto.app.ws.mobileappws.shared.dto.PostDto;
import com.appphoto.app.ws.mobileappws.shared.dto.UserDto;
import com.appphoto.app.ws.mobileappws.ui.model.request.PostRequestModel;
import com.appphoto.app.ws.mobileappws.ui.model.response.AddressRest;
import com.appphoto.app.ws.mobileappws.ui.model.response.PostRest;
import com.appphoto.app.ws.mobileappws.ui.model.response.UserRest;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/posts")
//@CrossOrigin(origins = "*")
public class PostController {

  @Autowired
  PostService postService;

  @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
          produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  public PostRest createPost(@RequestBody PostRequestModel postDetails) throws Exception{
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();

    PostRest returnValue = new PostRest();
    ModelMapper modelMapper = new ModelMapper();

    PostDto postDto = modelMapper.map(postDetails, PostDto.class);
    postDto.setPostDate(dateFormat.format(date));
    PostDto createPost = postService.createPost(postDto);

    returnValue = modelMapper.map(createPost, PostRest.class);

    return returnValue;
  }

  @GetMapping(path="/{postOwner}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  public List<PostRest> getPost(HttpServletResponse res, @PathVariable String postOwner) {
    List<PostRest> returnValue = new ArrayList<>();
//
    List<PostDto> postsDto = postService.getPost(postOwner);
    if(postsDto != null && !postsDto.isEmpty()) {
      java.lang.reflect.Type listType = new TypeToken<List<PostRest>>() {
      }.getType();
      returnValue = new ModelMapper().map(postsDto, listType);
    }

    return returnValue;
  }
}
