package org.example.chapter01.code;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Performance {
  @JsonProperty("playID")
  private String playId;
  private int audience;

  public String getPlayId() {
    return playId;
  }

  public int getAudience() {
    return audience;
  }

  @Override
  public String toString() {
    return "Performance{" +
        "playId='" + playId + '\'' +
        ", audience=" + audience +
        '}';
  }
}
