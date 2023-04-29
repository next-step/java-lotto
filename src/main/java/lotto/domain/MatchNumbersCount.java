package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum MatchNumbersCount {
  MATCH_0(0, new Money(0)),
  MATCH_1(1, new Money(0)),
  MATCH_2(2, new Money(0)),
  MATCH_3(3, new Money(5_000)),
  MATCH_4(4, new Money(50_000)),
  MATCH_5(5, new Money(1_500_000)),
  MATCH_5_AND_BONUS(5, new Money(30_000_000)),
  MATCH_6(6, new Money(2_000_000_000)),
  ;
  private static final Map<Integer, MatchNumbersCount> matchNumbersCounts = new HashMap<>();
  private final int matchNumbersCount;
  private final Money prize;

  static {
    for (MatchNumbersCount value : values()) {
      matchNumbersCounts.put(value.matchNumbersCount, value);
    }
  }

  public static MatchNumbersCount of(
      LottoNumbers lottoNumbers,
      LottoNumbers winningNumbers,
      LottoNumber bonusNumber
  ) {
    int count = (int) lottoNumbers.getNumbers().stream()
                                  .filter(winningNumbers::contains)
                                  .count();
    if (count == 5 && lottoNumbers.contains(bonusNumber)) {
      return MATCH_5_AND_BONUS;
    }
    return matchNumbersCounts.get(count);
  }

  MatchNumbersCount(int matchNumbersCount, Money prize) {
    this.matchNumbersCount = matchNumbersCount;
    this.prize = prize;
  }

  public int getMatchNumbersCount() {
    return matchNumbersCount;
  }

  public Money getPrize() {
    return prize;
  }
}
