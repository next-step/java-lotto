package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoReword {
  MATCH_THREE(5000), MATCH_FOUR(50000), MATCH_FIVE(1500000), MATCH_SIX(2000000000);

  private static final Map<Integer, LottoReword> lookup = new HashMap<>();

  static {
    lookup.put(3, MATCH_THREE);
    lookup.put(4, MATCH_FOUR);
    lookup.put(5, MATCH_FIVE);
    lookup.put(6, MATCH_SIX);
  }

  private final int money;

  LottoReword(int money) {
    this.money = money;
  }

  public static int getWinMoney(int matchCount) {
    LottoReword lottoReword = lookup.get(matchCount);
    if (lottoReword == null) {
      return 0;
    }

    return lottoReword.money;
  }

}
