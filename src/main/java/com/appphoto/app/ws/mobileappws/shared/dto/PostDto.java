package com.appphoto.app.ws.mobileappws.shared.dto;

import java.io.Serializable;

public class PostDto implements Serializable {

  private static final long serialVersionUID = -4543707521280271737L;
  private long id;
  private String postId;
  private String postOwner;
  private String postDate;
  private String postName;
  private String postDescription;
  private String postComments;
  private String postStatus;
  private boolean shareable;
  private String shareCounts;
  private String image;
  private int likes;
  private int haha;
  private int angry;
  private int sad;

  public String getPostId() {
    return postId;
  }

  public void setPostId(String postId) {
    this.postId = postId;
  }

  public String getPostOwner() {
    return postOwner;
  }

  public void setPostOwner(String postOwner) {
    this.postOwner = postOwner;
  }

  public String getPostDate() {
    return postDate;
  }

  public void setPostDate(String postDate) {
    this.postDate = postDate;
  }

  public String getPostName() {
    return postName;
  }

  public void setPostName(String postName) {
    this.postName = postName;
  }

  public String getPostDescription() {
    return postDescription;
  }

  public void setPostDescription(String postDescription) {
    this.postDescription = postDescription;
  }

  public String getPostComments() {
    return postComments;
  }

  public void setPostComments(String postComments) {
    this.postComments = postComments;
  }

  public String getPostStatus() {
    return postStatus;
  }

  public void setPostStatus(String postStatus) {
    this.postStatus = postStatus;
  }

  public boolean isShareable() {
    return shareable;
  }

  public void setShareable(boolean shareable) {
    this.shareable = shareable;
  }

  public String getShareCounts() {
    return shareCounts;
  }

  public void setShareCounts(String shareCounts) {
    this.shareCounts = shareCounts;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public int getLikes() {
    return likes;
  }

  public void setLikes(int likes) {
    this.likes = likes;
  }

  public int getHaha() {
    return haha;
  }

  public void setHaha(int haha) {
    this.haha = haha;
  }

  public int getAngry() {
    return angry;
  }

  public void setAngry(int angry) {
    this.angry = angry;
  }

  public int getSad() {
    return sad;
  }

  public void setSad(int sad) {
    this.sad = sad;
  }
}
