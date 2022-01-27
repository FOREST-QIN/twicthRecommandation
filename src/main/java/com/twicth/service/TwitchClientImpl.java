package com.twicth.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.twicth.entity.TokenEntity;
import com.twicth.entity.TwitchClientEntity;
import com.twicth.external.TwitchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Service("twitchClient")
public class TwitchClientImpl implements TwitchClient {
  @Autowired
  TwitchClientEntity twitchClientEntity;
  private RestTemplate restTemplate = new RestTemplate();

  private String getToken() {
    ResponseEntity<String> response = null;
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
      Map<String, Object> map = new HashMap<>();
      map.put("client_id", twitchClientEntity.getCLIENT_ID());
      map.put("client_secret", twitchClientEntity.getCLIENT_SECRETE());
      map.put("grant_type", "client_credentials");

      HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

      response = restTemplate.postForEntity(twitchClientEntity.getGET_TOKEN_URL(), entity, String.class);
    } catch (RestClientException e) {
      e.printStackTrace();
    }

    assert response != null;
    TokenEntity obj = JSON.parseObject(response.getBody(), TokenEntity.class);
    assert obj != null;
    return obj.getAccessToken();
  }

  //  @RequestMapping("/test")
  @Override
  public JSONArray getTopGame(Integer limit) {
    if (limit == null || limit < twitchClientEntity.getDEFAULT_LIMIT()) limit = twitchClientEntity.getDEFAULT_LIMIT();
    if (twitchClientEntity.getTOKEN() == null) {
      twitchClientEntity.setTOKEN(getToken());
    }
    ResponseEntity<String> response = null;

    JSONObject array = null;
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
      headers.add("Authorization", "Bearer " + twitchClientEntity.getTOKEN());
      headers.add("Client-Id", twitchClientEntity.getCLIENT_ID());

      Map<String, Object> map = new HashMap<>();
      map.put("first", limit);
      HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

      response = restTemplate.exchange(twitchClientEntity.getTOP_GAME_URL(), HttpMethod.GET, new HttpEntity<Object>(headers), String.class);
      array = JSONObject.parseObject(response.getBody());
    } catch (TwitchException e) {
      e.printStackTrace();
    }

    return array.getJSONArray("data");
  }

  //  @RequestMapping("/test2")
  @Override
  public JSONArray getGame(String game) {
    if (game == null || game.length() == 0) throw new IllegalArgumentException("Must specify a game name");
    if (twitchClientEntity.getTOKEN() == null) {
      twitchClientEntity.setTOKEN(getToken());
    }

    ResponseEntity<String> response = null;
    JSONObject array = null;

    try {
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
      headers.add("Authorization", "Bearer " + twitchClientEntity.getTOKEN());
      headers.add("Client-Id", twitchClientEntity.getCLIENT_ID());
      UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(twitchClientEntity.getGET_GAME_URL()).queryParam("name", game);
//      Map<String, Object> map = new HashMap<>();
//      map.put("name", game);
      HttpEntity<Map<String, Object>> entity = new HttpEntity<>(headers);

      response = restTemplate.exchange(builder.build().encode().toUri(),
          HttpMethod.GET,
          entity,
          String.class);
    } catch (TwitchException e) {
      e.printStackTrace();
    }

    array = JSONObject.parseObject(response.getBody());
    return array.getJSONArray("data");
  }


  public JSONArray getStreams(Integer limit) {
    if (twitchClientEntity.getTOKEN() == null) {
      twitchClientEntity.setTOKEN(getToken());
    }
    if (limit == null) limit = twitchClientEntity.getDEFAULT_LIMIT();
    ResponseEntity<String> response = null;
    JSONObject array = null;

    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Bearer " + twitchClientEntity.getTOKEN());
    headers.add("Client-Id", twitchClientEntity.getCLIENT_ID());
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(twitchClientEntity.getGET_STREAMS_URL())
        .queryParam("first", limit.intValue());
    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(headers);

    response = restTemplate.exchange(builder.build().encode().toUri()
        , HttpMethod.GET
        , entity
        , String.class);
    array = JSONObject.parseObject(response.getBody());
    return array.getJSONArray("data");
  }

  @Override
  public JSONArray getVideos(Integer id, String userId, String gameId) {
    if (twitchClientEntity.getTOKEN() == null) {
      twitchClientEntity.setTOKEN(getToken());
    }
    ResponseEntity<String> response = null;
    JSONObject array = null;

    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Bearer " + twitchClientEntity.getTOKEN());
    headers.add("Client-Id", twitchClientEntity.getCLIENT_ID());
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(twitchClientEntity.getGET_VIDEOS_URL());
    if (id != null) {
      builder.queryParam("id", id);
    }
    if (userId != null) {
      builder.queryParam("user_id", userId);
    }
    if (gameId != null) {
      builder.queryParam("game_id", gameId);
    }

    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(headers);
    response = restTemplate.exchange(builder.build().encode().toUri()
        , HttpMethod.GET
        , entity
        , String.class);
    array = JSON.parseObject(response.getBody());

    return array.getJSONArray("data");
  }

  @Override
  public JSONArray getClips(String id, String gameId, String broadCastID) {
    if (twitchClientEntity.getTOKEN() == null) {
      twitchClientEntity.setTOKEN(getToken());
    }
    ResponseEntity<String> response = null;
    JSONObject array = null;

    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Bearer " + twitchClientEntity.getTOKEN());
    headers.add("Client-Id", twitchClientEntity.getCLIENT_ID());
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(twitchClientEntity.getGET_CLIPS_URL());

    if (id != null) {
      builder.queryParam("id", id);
    }
    if (gameId != null) {
      builder.queryParam("game_id", gameId);
    }
    if (broadCastID != null) {
      builder.queryParam("broadcaster_id", broadCastID);
    }

    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(headers);
    response = restTemplate.exchange(builder.build().encode().toUri()
        , HttpMethod.GET
        , entity
        , String.class
    );
    array = JSON.parseObject(response.getBody());
    return array.getJSONArray("data");
  }

}
