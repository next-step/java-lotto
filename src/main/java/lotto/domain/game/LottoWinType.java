package lotto.domain.game;

import java.util.Arrays;

public enum LottoWinType {

  RANK_5(3, 5_000),
  RANK_4(4, 50_000),
  RANK_3(5, 1_500_000, false),
  RANK_2(5, 3_000_000, true),
  RANK_1(6, 2_000_000_000),

  NONE (0, 0),
  ;

  private final int matchingNumberCnt;
  private final boolean isBonusNumberRequired;
  private final int prize;

  LottoWinType (int matchingNumberCnt, int prize) {
    this.matchingNumberCnt = matchingNumberCnt;
    this.prize = prize;
    this.isBonusNumberRequired = false;
  }

  LottoWinType (int matchingNumberCnt, int prize, boolean isBonusNumberRequired) {
    this.matchingNumberCnt = matchingNumberCnt;
    this.prize = prize;
    this.isBonusNumberRequired = isBonusNumberRequired;
  }

  public int getMatchingNumberCnt() {
    return matchingNumberCnt;
  }

  public int getPrize() {
    return prize;
  }

  public static LottoWinType getWinTypeByMatchingCnt (int matchingNumberCnt, boolean isBonusNumberRequired) {
    return Arrays.stream(values())
        .filter(winType -> winType.isMatchCondition(matchingNumberCnt, isBonusNumberRequired))
        .findFirst()
        .orElse(NONE);
  }

  public static LottoWinType[] getWithPrizedWinType() {
    return Arrays.stream(values())
        .filter(lottoWinType -> lottoWinType.prize > 0)
        .toArray(LottoWinType[]::new);
  }

  public boolean isBonusNumberRequired() {
    return isBonusNumberRequired;
  }

  private boolean isMatchCondition(int matchingNumberCnt, boolean isBonusNumberRequired) {
    boolean numberCntMatch = this.matchingNumberCnt == matchingNumberCnt;
    boolean bonusNumberRequiredMatch = this.isBonusNumberRequired == isBonusNumberRequired;
    return numberCntMatch && bonusNumberRequiredMatch;
  }
}
