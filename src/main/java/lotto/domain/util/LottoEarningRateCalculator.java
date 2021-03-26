package lotto.domain.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

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

  public String resultToString() {
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    decimalFormat.setRoundingMode(RoundingMode.DOWN);

    return decimalFormat.format(eval());
  }

  private double eval() {
    if (principal > 0) {
      return earning / (double) principal;
    }
    return 0;
  }
}
