package org.example.chapter01.code;

public class Play {
  private String name;
  private String type;

  public PlayType getType() {
    String lowerCase = this.type.toLowerCase();
    return PlayType.valueOf(this.type.toUpperCase());
  }

  public String  getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Play{" +
        "name='" + name + '\'' +
        ", type=" + type +
        '}';
  }
}
