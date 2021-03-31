package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {

  NONE(Integer.MIN_VALUE, 0),
  FIFTH(3, 5000),
  FOURTH(4, 50000),
  THIRD(5, 1500000),
  SECOND(5, 30000000),
  FIRST(6, 2000000000);

  private static final int THIRD_OR_SECOND_CRITERIA = 5;

  private int matchCount;
  private Money winnerMoney;

  LottoRank(int matchCount, int winnerMoney) {
    this.matchCount = matchCount;
    this.winnerMoney = new Money(winnerMoney);
  }

  public Money getWinnerMoney() {
    return winnerMoney;
  }

  public static LottoRank findRank(String winnerRank) {
    return Arrays.stream(LottoRank.values())
        .filter(matches -> matches.name().equals(winnerRank))
        .findAny()
        .orElseThrow(IllegalArgumentException::new);
  }

  public static LottoRank valueOf(int matchCount, boolean bonusBall) {
    return Arrays.stream(LottoRank.values())
        .filter(rank -> isThirdOrSecond(matchCount) ?
            filterIsSecond(bonusBall, rank.winnerMoney) : rank.matchCount == matchCount)
        .findAny()
        .orElse(LottoRank.NONE);
  }

  private static boolean isThirdOrSecond(int matchCount) {
    return matchCount == THIRD_OR_SECOND_CRITERIA;
  }

  private static boolean filterIsSecond(boolean bonusBall, Money winnerMoney) {
    return bonusBall ? winnerMoney.equals(new Money(30000000)) : winnerMoney.equals(new Money(1500000));
  }

  public static LottoRank matches(List<Number> winningNumbers, List<Number> holdingLottoNumbers, Number bonusBall) {
    int matchCount =  Math.toIntExact(winningNumbers.stream()
        .filter(holdingLottoNumbers::contains)
        .count());
    boolean isSecond = holdingLottoNumbers.contains(bonusBall);
    return LottoRank.valueOf(matchCount, isSecond);
  }

  public static boolean isNone(LottoRank lottoRank) {
    return lottoRank == LottoRank.NONE;
  }
}
