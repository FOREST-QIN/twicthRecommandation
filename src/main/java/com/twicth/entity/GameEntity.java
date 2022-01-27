package com.twicth.entity;

import java.io.Serializable;

public class GameEntity implements Serializable {
  String  id;
  String name;
  String boxArtUrl;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBoxArtUrl() {
    return boxArtUrl;
  }

  public void setBoxArtUrl(String boxArtUrl) {
    this.boxArtUrl = boxArtUrl;
  }
}
