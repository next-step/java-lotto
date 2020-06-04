package lotto.model;

import java.util.Objects;

public class MatchCnt implements Comparable<MatchCnt> {

  private int cnt;
  private boolean matchBonus;

  public MatchCnt(int cnt, boolean matchBonus) {
    this.cnt = cnt;
    this.matchBonus = matchBonus;
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
    return cnt == matchCnt.cnt &&
        matchBonus == matchCnt.matchBonus;
  }

  @Override
  public int hashCode() {
    return Objects.hash(cnt, matchBonus);
  }

  @Override
  public String toString() {
    return "MatchCnt{" +
        "cnt=" + cnt +
        ", matchBonus=" + matchBonus +
        '}';
  }

  @Override
  public int compareTo(MatchCnt target) {
    return Integer.compare(this.cnt, target.cnt);
  }
}
