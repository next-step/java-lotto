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

  public LottoRank match(Lotto manualLotto) {
    return LottoRank.valueOf(winningNumber.matchCount(manualLotto),
        hasBonusBall(manualLotto));
  }

  public boolean hasBonusBall(Lotto lotto) {
    return lotto.contains(bonusBall);
  }
}
