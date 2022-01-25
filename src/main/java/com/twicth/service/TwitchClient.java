package com.twicth.service;

import com.alibaba.fastjson.JSONObject;

public interface TwitchClient {
  public JSONObject getTopGame(int limit);
  public JSONObject getGame(String game);
}
