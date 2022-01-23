package com.example.twicthrecommandation.service;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
@RequestMapping("/twitch")
public class TwitchClient {
  @GetMapping("/test")
  public String getToken(@RequestParam(value = "id", defaultValue = "8e01o19kutsb5znw40q2v4yhl0t4ci") String clientId, @RequestParam(value = "secrete", defaultValue = "5ua8b5fuy5mf3nxvunmm7g9a66otxi") String clientSecrete) {
    return clientId + clientSecrete;
  }
}
