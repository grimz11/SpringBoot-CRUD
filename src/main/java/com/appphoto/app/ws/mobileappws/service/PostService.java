package com.appphoto.app.ws.mobileappws.service;

import com.appphoto.app.ws.mobileappws.shared.dto.PostDto;

import java.util.List;

public interface PostService {
  PostDto createPost(PostDto post);
  List<PostDto> getPost(String postOwner);
}
