package com.appphoto.app.ws.mobileappws.ui.model.request;

public class PostRequestModel {
  private String postName;
  private String postDescription;
  private String postComments;
  private String postStatus;
  private boolean shareable;
  private String image;

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

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
}
