package com.twicth.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface TwitchClient {
  public JSONArray getTopGame(Integer limit);
  public JSONObject getGame(String game);
}
