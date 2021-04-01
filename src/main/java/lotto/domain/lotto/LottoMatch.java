package lotto.domain.lotto;

import static lotto.domain.lotto.LottoNumbers.LOTTO_NUMBER_COUNT;

import java.util.Objects;
import lotto.exception.IllegalBonusConditionException;
import lotto.exception.InvalidMatchCountException;

public final class LottoMatch {

  private final int matchCount;
  private final boolean isBonusNumberMatch;

  public LottoMatch(int matchCount, boolean isBonusNumberMatch) {
    validate(matchCount, isBonusNumberMatch);
    this.matchCount = matchCount;
    this.isBonusNumberMatch = isBonusNumberMatch;
  }

  private void validate(int matchCount, boolean isBonusNumberMatch) {
    if (matchCount > LOTTO_NUMBER_COUNT) {
      throw new InvalidMatchCountException();
    }
    if (matchCount < LOTTO_NUMBER_COUNT - 1 && isBonusNumberMatch) {
      throw new IllegalBonusConditionException();
    }
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
