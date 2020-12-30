package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoStatistics {

    public static final int TWO_DECIMAL = 2;

    public double rateOfReturn(int winningAmount, int purchaseAmount) {
         return BigDecimal.valueOf((double) winningAmount / (double) purchaseAmount).setScale(TWO_DECIMAL,RoundingMode.DOWN).doubleValue();
    }
}
