package com.twicth.entity;

public class StreamEntity {
  String id;
  String userId;
  String userLogin;
  String userName;
  String gameId;
  String type;
  String title;
  String viewerCount;
  String startedAt;
  String language;
  String thumbnailUrl;
  Boolean isMature;

  public StreamEntity(String id, String userId, String userLogin, String userName, String gameId, String type, String title, String viewerCount, String startedAt, String language, String thumbnailUrl, Boolean isMature) {
    this.id = id;
    this.userId = userId;
    this.userLogin = userLogin;
    this.userName = userName;
    this.gameId = gameId;
    this.type = type;
    this.title = title;
    this.viewerCount = viewerCount;
    this.startedAt = startedAt;
    this.language = language;
    this.thumbnailUrl = thumbnailUrl;
    this.isMature = isMature;
  }

  public StreamEntity() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserLogin() {
    return userLogin;
  }

  public void setUserLogin(String userLogin) {
    this.userLogin = userLogin;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getGameId() {
    return gameId;
  }

  public void setGameId(String gameId) {
    this.gameId = gameId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getViewerCount() {
    return viewerCount;
  }

  public void setViewerCount(String viewerCount) {
    this.viewerCount = viewerCount;
  }

  public String getStartedAt() {
    return startedAt;
  }

  public void setStartedAt(String startedAt) {
    this.startedAt = startedAt;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getThumbnailUrl() {
    return thumbnailUrl;
  }

  public void setThumbnailUrl(String thumbnailUrl) {
    this.thumbnailUrl = thumbnailUrl;
  }

  public Boolean getMature() {
    return isMature;
  }

  public void setMature(Boolean mature) {
    isMature = mature;
  }
}
