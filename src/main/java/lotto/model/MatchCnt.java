package lotto.model;

import java.util.Objects;

public class MatchCnt implements Comparable<MatchCnt> {

  private int value;
  private boolean matchBonus;

  public MatchCnt(int value, boolean matchBonus) {
    this.value = value;
    this.matchBonus = matchBonus;
  }

  public int getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MatchCnt matchCnt = (MatchCnt) o;
    return value == matchCnt.value &&
        matchBonus == matchCnt.matchBonus;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, matchBonus);
  }

  @Override
  public String toString() {
    String message = value + "개 일치";
    if (matchBonus) {
      message = message.concat(", 보너스 볼 일치");
    }
    return message;
  }

  @Override
  public int compareTo(MatchCnt target) {
    return Integer.compare(this.value, target.value);
  }
}
