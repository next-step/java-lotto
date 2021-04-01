package lotto.domain.lotto;

import static lotto.domain.lotto.LottoNumbers.LOTTO_NUMBER_COUNT;

import java.util.Objects;

public final class LottoMatch {

  public static final String INVALID_MATCH_COUNT = "로또 숫자보다 일치하는 갯수가 많을 수 없습니다.";
  public static final String INVALID_BONUS_CONDITION = "보너스 번호가 일치할 수 없는 조건입니다.";
  private final int matchCount;
  private final boolean isBonusNumberMatch;

  public LottoMatch(int matchCount, boolean isBonusNumberMatch) {
    validate(matchCount, isBonusNumberMatch);
    this.matchCount = matchCount;
    this.isBonusNumberMatch = isBonusNumberMatch;
  }

  private void validate(int matchCount, boolean isBonusNumberMatch) {
    if (matchCount > LOTTO_NUMBER_COUNT) {
      throw new IllegalArgumentException(INVALID_MATCH_COUNT);
    }
    if (matchCount < LOTTO_NUMBER_COUNT - 1 && isBonusNumberMatch) {
      throw new IllegalArgumentException(INVALID_BONUS_CONDITION);
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
