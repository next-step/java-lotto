package lotto.domain;

public class WinningNumber {

  private final Lotto winningNumber;
  private final Number bonusBall;

  public WinningNumber(Lotto winningNumber, Number bonusBall) {
    this.winningNumber = winningNumber;
    this.bonusBall = bonusBall;
  }

  public static WinningNumber createWinningNumbers(Lotto winningNumber, Number bonusBall) {
    return new WinningNumber(winningNumber, bonusBall);
  }

  public LottoScoreBoard generateLottoMatchResult(Money money, LottoCoupon coupon,
      WinningNumber winningNumber) {
    return LottoScoreBoard.createLottoResult(money, coupon.matches(winningNumber));
  }

  public int contains(Lotto lotto) {
    return lotto.matchCount(winningNumber);
  }

  public boolean hasBonusBall(Lotto lotto) {
    return lotto.contains(bonusBall);
  }
}
