package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoReword {
  MATCH_THREE(5000), MATCH_FOUR(50000), MATCH_FIVE(1500000), MATCH_FIVE_WITH_BONUS(
      30000000), MATCH_SIX(2000000000);

  private static final Map<Integer, LottoReword> lookup = new HashMap<>();
  private static final Map<Integer, LottoReword> bonusLookup = new HashMap<>();

  static {
    lookup.put(3, MATCH_THREE);
    lookup.put(4, MATCH_FOUR);
    lookup.put(5, MATCH_FIVE);
    lookup.put(6, MATCH_SIX);
    bonusLookup.put(5, MATCH_FIVE_WITH_BONUS);
  }

  private final int money;

  LottoReword(int money) {
    this.money = money;
  }

  public static int getWinMoney(int matchCount, boolean isBonusMatch) {
    if (isBonusMatch) {
      return getWinMoneyWithBonus(matchCount);
    }
    return getWinMoneyNoBonus(matchCount);

  }

  private static int getWinMoneyWithBonus(int matchCount) {
    LottoReword lottoReword = bonusLookup.get(matchCount);
    if (lottoReword == null) {
      return getWinMoneyNoBonus(matchCount);
    }

    return lottoReword.money;
  }

  private static int getWinMoneyNoBonus(int matchCount) {
    LottoReword lottoReword = lookup.get(matchCount);
    if (lottoReword == null) {
      return 0;
    }

    return lottoReword.money;
  }

}
