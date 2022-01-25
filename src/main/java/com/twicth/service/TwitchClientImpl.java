package com.twicth.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.twicth.entity.TokenEntity;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Controller
@ResponseBody
@RequestMapping("/twitch")
public class TwitchClientImpl implements TwitchClient {
  static String URL = "https://id.twitch.tv/oauth2/token";
  static String CLIENT_ID = "8e01o19kutsb5znw40q2v4yhl0t4ci";
  static String CLIENT_SECRETE = "5ua8b5fuy5mf3nxvunmm7g9a66otxi";
  private final static String TOKEN = getToken();
  private static final RestTemplate restTemplate = new RestTemplate();

  private static String getToken() {
    ResponseEntity<String> response = null;
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
      Map<String, Object> map = new HashMap<>();
      map.put("client_id", CLIENT_ID);
      map.put("client_secret", CLIENT_SECRETE);
      map.put("grant_type", "client_credentials");

      HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

      response = restTemplate.postForEntity(URL, entity, String.class);
    } catch (RestClientException e) {
      e.printStackTrace();
    }

    assert response != null;
    TokenEntity obj = JSON.parseObject(response.getBody(), TokenEntity.class);
    assert obj != null;
    return obj.getAccessToken();
  }

  @Override
  public JSONObject getTopGame(int limit) {
    return null;
  }

  @Override
  public JSONObject getGame(String game) {
    return null;
  }
}
