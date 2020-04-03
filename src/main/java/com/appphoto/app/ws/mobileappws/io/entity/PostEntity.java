package com.appphoto.app.ws.mobileappws.io.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="posts")
public class PostEntity implements Serializable {

  private static final long serialVersionUID = 8224724365207877570L;
  @Id
  @GeneratedValue
  private long id;

  @Column(nullable = false)
  private String postId;

  @Column()
  private String postOwner;

  @JsonFormat(pattern = "MM-dd-yyyy")
  @Column(name="date_created")
  private String postDate;

  @Column(nullable = false, length = 100)
  private String postName;

  @Column()
  private String postDescription;

  @Column()
  private String postComments;

  @Column()
  private String postStatus;

  @Column()
  private boolean shareable;

  @Column()
  private String shareCounts;

  @Column()
  private String image;

  @Column()
  private int likes;

  @Column()
  private int haha;

  @Column()
  private int angry;

  @Column()
  private int sad;

  @ManyToOne
  @JoinColumn(name="user_id")
  private UserEntity postDetails;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

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

  public UserEntity getPostDetails() {
    return postDetails;
  }

  public void setPostDetails(UserEntity postDetails) {
    this.postDetails = postDetails;
  }
}
