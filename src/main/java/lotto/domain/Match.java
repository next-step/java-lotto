package lotto.domain;

import java.util.Objects;

public final class Match {

  private final int matchCount;
  private final boolean isBonusNumberMatch;

  public Match(int matchCount, boolean isBonusNumberMatch) {
    this.matchCount = matchCount;
    this.isBonusNumberMatch = isBonusNumberMatch;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public boolean isBonusNumberMatch() {
    return isBonusNumberMatch;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Match)) {
      return false;
    }
    Match match = (Match) o;
    return getMatchCount() == match.getMatchCount() && isBonusNumberMatch == match.isBonusNumberMatch;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMatchCount(), isBonusNumberMatch);
  }
}
