package lotto;

public class LottoTicket {

  private final LottoNumberBundle bundle;

  private LottoTicket(LottoNumberBundle bundle) {
    this.bundle = bundle;
  }

  public static LottoTicket of(LottoNumberBundle bundle) {
    return new LottoTicket(bundle);
  }

  public int guessNumHit(WinningNumber winningNumber) {
    int result = 0;
    for (LottoNumber lottoNumber : winningNumber) {
      result += this.bundle.contains(lottoNumber) ? 1 : 0;
    }
    return result;
  }

  public Rank rewardsWithBonusBall(WinningNumber winningNumber) {
    int numHit = this.guessNumHit(winningNumber);
    boolean matchedWithBonusBall = this.bundle.contains(winningNumber.getBonusNumber());
    return Rank.getRewardWithBonusBall(numHit, matchedWithBonusBall);
  }

  @Override
  public String toString() {
    return this.bundle.toString();
  }
}
