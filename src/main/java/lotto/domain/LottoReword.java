package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoReword {
  FIRST(6, false, 2000000000),
  SECOND(5, true, 30000000),
  THIRD(5, false, 1500000),
  FOURTH(4, false, 50000),
  FIFTH(3, false, 5000),
  NO_REWORD(0, false, 0);

  private static final Map<Integer, LottoReword> lookup = new HashMap<>();
  private static final Map<Integer, LottoReword> bonusLookup = new HashMap<>();

  static {
    lookup.put(3, FIFTH);
    lookup.put(4, FOURTH);
    lookup.put(5, THIRD);
    lookup.put(6, FIRST);
    bonusLookup.put(5, SECOND);
  }

  private final int matchCount;
  private final boolean isBonusMatch;
  private final int money;

  LottoReword(int matchCount, boolean isBonusMatch, int money) {
    this.matchCount = matchCount;
    this.isBonusMatch = isBonusMatch;
    this.money = money;
  }

  public static LottoReword getReword(int matchCount, boolean isBonusMatch) {
    if (isBonusMatch) {
      return getRewordWithBonus(matchCount);
    }
    return getRewordNoBonus(matchCount);
  }

  public boolean isBonusMatch() {
    return isBonusMatch;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public int getMoney() {
    return money;
  }

  private static LottoReword getRewordWithBonus(int matchCount) {
    LottoReword lottoReword = bonusLookup.get(matchCount);
    if (lottoReword != null) {
      return lottoReword;
    }

    return getRewordNoBonus(matchCount);
  }

  private static LottoReword getRewordNoBonus(int matchCount) {
    LottoReword lottoReword = lookup.get(matchCount);
    if (lottoReword == null) {
      return NO_REWORD;
    }

    return lottoReword;
  }


}
