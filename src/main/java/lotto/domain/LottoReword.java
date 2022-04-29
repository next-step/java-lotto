package lotto.domain;

import lotto.exception.LottoRewordNotExistException;

public enum LottoReword {
  MATCH_ZERO(0), MATCH_ONE(0), MATCH_TWO(0), MATCH_THREE(5000), MATCH_FOUR(50000), MATCH_FIVE(
      1500000), MATCH_SIX(2000000000);

  private final int money;

  LottoReword(int money) {
    this.money = money;
  }

  public static int getWinMoney(int matchCount) {
    if (notValidMatchCount(matchCount)) {
      throw new LottoRewordNotExistException(matchCount);
    }
    return LottoReword.values()[matchCount].money;
  }

  private static boolean notValidMatchCount(int matchCount) {
    return matchCount < 0 || matchCount >= LottoReword.values().length;
  }

}
