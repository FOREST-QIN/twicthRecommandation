package com.twicth.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@PropertySource("classpath:src/main/resources/application.yml")
@Component
@ConfigurationProperties(prefix = "twitchcliententity")
public class TwitchClientEntity {
  private String GET_STREAMS_URL;
  private String GET_VIDEOS_URL;
  private String GET_CLIPS_URL;
  private String GET_GAME_URL;
  private String GET_TOKEN_URL;
  private String TOP_GAME_URL;
  private String CLIENT_ID;
  private String CLIENT_SECRETE;
  private String TOKEN;
  private Integer STREAM_TYPE;
  private Integer VIDEO_TYPE;
  private Integer CLIP_TYPE;



  private int DEFAULT_LIMIT;


  public TwitchClientEntity() {
  }


  public TwitchClientEntity(String GET_TOKEN_URL, String TOP_GAME_URL, String CLIENT_ID, String CLIENT_SECRETE, int DEFAULT_LIMIT) {
    this.GET_TOKEN_URL = GET_TOKEN_URL;
    this.TOP_GAME_URL = TOP_GAME_URL;
    this.CLIENT_ID = CLIENT_ID;
    this.CLIENT_SECRETE = CLIENT_SECRETE;
    this.DEFAULT_LIMIT = DEFAULT_LIMIT;
  }

  public String getGET_GAME_URL() {
    return GET_GAME_URL;
  }

  public void setGET_GAME_URL(String GET_GAME_URL) {
    this.GET_GAME_URL = GET_GAME_URL;
  }

  public String getGET_TOKEN_URL() {
    return GET_TOKEN_URL;
  }

  public void setGET_TOKEN_URL(String GET_TOKEN_URL) {
    this.GET_TOKEN_URL = GET_TOKEN_URL;
  }

  public String getTOP_GAME_URL() {
    return TOP_GAME_URL;
  }

  public void setTOP_GAME_URL(String TOP_GAME_URL) {
    this.TOP_GAME_URL = TOP_GAME_URL;
  }

  public String getCLIENT_ID() {
    return CLIENT_ID;
  }

  public void setCLIENT_ID(String CLIENT_ID) {
    this.CLIENT_ID = CLIENT_ID;
  }

  public String getCLIENT_SECRETE() {
    return CLIENT_SECRETE;
  }

  public void setCLIENT_SECRETE(String CLIENT_SECRETE) {
    this.CLIENT_SECRETE = CLIENT_SECRETE;
  }

  public int getDEFAULT_LIMIT() {
    return DEFAULT_LIMIT;
  }

  public void setDEFAULT_LIMIT(int DEFAULT_LIMIT) {
    this.DEFAULT_LIMIT = DEFAULT_LIMIT;
  }

  public String getTOKEN() {
    return TOKEN;
  }

  public void setTOKEN(String TOKEN) {
    this.TOKEN = TOKEN;
  }

  public String getGET_STREAMS_URL() {
    return GET_STREAMS_URL;
  }

  public void setGET_STREAMS_URL(String GET_STREAMS_URL) {
    this.GET_STREAMS_URL = GET_STREAMS_URL;
  }

  public String getGET_VIDEOS_URL() {
    return GET_VIDEOS_URL;
  }

  public void setGET_VIDEOS_URL(String GET_VIDEOS_URL) {
    this.GET_VIDEOS_URL = GET_VIDEOS_URL;
  }

  public String getGET_CLIPS_URL() {
    return GET_CLIPS_URL;
  }

  public void setGET_CLIPS_URL(String GET_CLIPS_URL) {
    this.GET_CLIPS_URL = GET_CLIPS_URL;
  }

  public Integer getSTREAM_TYPE() {
    return STREAM_TYPE;
  }

  public void setSTREAM_TYPE(Integer STREAM_TYPE) {
    this.STREAM_TYPE = STREAM_TYPE;
  }

  public Integer getVIDEO_TYPE() {
    return VIDEO_TYPE;
  }

  public void setVIDEO_TYPE(Integer VIDEO_TYPE) {
    this.VIDEO_TYPE = VIDEO_TYPE;
  }

  public Integer getCLIP_TYPE() {
    return CLIP_TYPE;
  }

  public void setCLIP_TYPE(Integer CLIP_TYPE) {
    this.CLIP_TYPE = CLIP_TYPE;
  }
}
