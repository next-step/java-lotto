package lotto.domain.util;

public class LottoEarningRateCalculator {
  private final long principal;
  private long earning;

  public LottoEarningRateCalculator(int purchasedCount) {
    principal = purchasedCount * LottoConstant.PRICE;
    earning = 0L;
  }

  public void cumulateEarning(long prize) {
    earning += prize;
  }

  public String eval() {
    return "0";
  }
}
