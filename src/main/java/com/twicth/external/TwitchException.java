package com.twicth.external;

public class TwitchException extends RuntimeException {
  public TwitchException(String errorMessage) {
    super(errorMessage);
  }
}
