package lotto.domain.lotto;

import java.util.Objects;

public final class LottoMatch {

  private final int matchCount;
  private final boolean isBonusNumberMatch;

  public LottoMatch(int matchCount, boolean isBonusNumberMatch) {
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
    if (!(o instanceof LottoMatch)) {
      return false;
    }
    LottoMatch lottoMatch = (LottoMatch) o;
    return getMatchCount() == lottoMatch.getMatchCount() && isBonusNumberMatch == lottoMatch.isBonusNumberMatch;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMatchCount(), isBonusNumberMatch);
  }
}
