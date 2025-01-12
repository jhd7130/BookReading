package org.example.chapter01.code;

import java.util.HashMap;
import java.util.Map;

public class Plays {
  private Map<String, Play> plays = new HashMap<>();

  public Plays(Map<String, Play> plays) {
    this.plays = plays;
  }

  public Play get(Performance performance) {
    return plays.get(performance.getPlayId());
  }

  @Override
  public String toString() {
    return "Plays{" +
        "plays=" + plays +
        '}';
  }
}
