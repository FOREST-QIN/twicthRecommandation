package com.twicth.service;

import com.alibaba.fastjson.JSONArray;

public interface TwitchClient {
  public JSONArray getTopGame(Integer limit);
  public JSONArray getGame(String game);
  public JSONArray getStreams(Integer limit);
  public JSONArray getClips(String id, String gameId, String broadCastID);
  public JSONArray getVideos(Integer id, String userId, String gameId);
}
