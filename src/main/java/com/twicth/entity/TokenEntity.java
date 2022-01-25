package com.twicth.entity;


/*
{"access_token":"mgvmrum980j4k660uuv0xwjtt8bxrb",
"expires_in":5214481,
"token_type":"bearer"}
 */
public class TokenEntity {
  String accessToken;
  String expiresIn;
  String tokenType;

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getExpiresIn() {
    return expiresIn;
  }

  public void setExpiresIn(String expiresIn) {
    this.expiresIn = expiresIn;
  }

  public String getTokenType() {
    return tokenType;
  }

  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }

  public TokenEntity() {
  }
}
