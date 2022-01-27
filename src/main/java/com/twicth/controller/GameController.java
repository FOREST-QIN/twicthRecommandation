package com.twicth.controller;

import com.alibaba.fastjson.JSONArray;
import com.twicth.external.TwitchException;
import com.twicth.service.TwitchClient;
import com.twicth.service.TwitchClientImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

// get game, search
@Controller
@ResponseBody
@RequestMapping("/twitch/search")
public class GameController {
  @Resource
  TwitchClient twitchClient = new TwitchClientImpl();

  @GetMapping("/game")
  public JSONArray getGame(@RequestParam(name = "game", required = false) String game, @RequestParam(value = "limit", required = false, defaultValue = "20") int limit) {
    if (game == null) {
      return twitchClient.getTopGame(limit);
    } else {
      return twitchClient.getGame(game);
    }
  }

  @GetMapping("/streams")
  public JSONArray getStreams(@RequestParam(name = "limit", required = false) Integer limit) {
    return twitchClient.getStreams(limit);
  }

  @GetMapping("/videos")
  public JSONArray getVideos(@RequestParam(name = "id", required = false) Integer id
      , @RequestParam(name = "userId", required = false) String userId
      , @RequestParam(name = "gameId", required = false) String gameId) throws TwitchException {
    if (id == null && userId == null && gameId == null)
      throw new TwitchException("must specify one or more video ids, one user_id, or one game_id.");

    return twitchClient.getVideos(id, userId, gameId);
  }

  @GetMapping("/clips")
  public JSONArray getClips(@RequestParam(name = "id", required = false) String id
      , @RequestParam(name = "gameId", required = false) String gameId
      , @RequestParam(name = "broadCastID", required = false) String broadCastID) throws TwitchException {
    if (id == null && gameId == null && broadCastID == null)
      throw new TwitchException("For a query to be valid, id (one or more)," +
          " broadcaster_id, or game_id must be specified. You may specify only one of these parameters.");


    return twitchClient.getClips(id, gameId, broadCastID);
  }
}
