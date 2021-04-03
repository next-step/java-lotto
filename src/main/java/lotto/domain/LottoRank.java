package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoRank implements LottoRankFilter {

  NONE(Integer.MIN_VALUE, 0),
  FIFTH(3, 5000),
  FOURTH(4, 50000),
  THIRD(5, 1500000) {
    @Override
    public boolean filter(boolean bonusBall, Money winnerMoney) {
      return !bonusBall && isCorrectWinnerMoney(winnerMoney);
    }
  },
  SECOND(5, 30000000) {
    @Override
    public boolean filter(boolean bonusBall, Money winnerMoney) {
      return bonusBall && isCorrectWinnerMoney(winnerMoney);
    }
  },
  FIRST(6, 2000000000);

  private final int matchCount;
  private final Money winnerMoney;

  LottoRank(int matchCount, int winnerMoney) {
    this.matchCount = matchCount;
    this.winnerMoney = new Money(winnerMoney);
  }

  public boolean isCorrectMatchCount(int matchCount) {
    return this.matchCount == matchCount;
  }

  public boolean isCorrectWinnerMoney(Money winnerMoney) {
    return this.winnerMoney == winnerMoney;
  }

  public Money getMatchedLottoWinningMoney(int value) {
    return winnerMoney.multiple(value);
  }

  @Override
  public boolean filter(boolean bonusBall, Money winnerMoney) {
    return isCorrectMatchCount(matchCount);
  }

  public static LottoRank findRank(String winnerRank) {
    return Arrays.stream(LottoRank.values())
        .filter(rank -> rank.name().equals(winnerRank))
        .findAny()
        .orElse(LottoRank.NONE);
  }

  public static LottoRank valueOf(int matchCount, boolean bonusBall) {
    return Arrays.stream(LottoRank.values())
        .filter(rank -> rank.isCorrectMatchCount(matchCount))
        .filter(rank -> rank.filter(bonusBall, rank.winnerMoney))
        .findAny()
        .orElse(LottoRank.NONE);
  }

  public static LottoRank matches(List<Number> winningNumbers, List<Number> holdingLottoNumbers, Number bonusBall) {
    int matchCount =  Math.toIntExact(winningNumbers.stream()
        .filter(holdingLottoNumbers::contains)
        .count());
    boolean hasBonusBall = holdingLottoNumbers.contains(bonusBall);
    return LottoRank.valueOf(matchCount, hasBonusBall);
  }

  public static boolean isNone(LottoRank lottoRank) {
    return lottoRank == LottoRank.NONE;
  }
}
