package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Result {
    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static BigDecimal getEarningRate(int purchaseAmount, int earnAmount) {
        BigDecimal purchaseAmountDecimal = new BigDecimal(purchaseAmount);
        BigDecimal earnAmountDecimal = new BigDecimal(earnAmount);
        return earnAmountDecimal.divide(purchaseAmountDecimal, 2, RoundingMode.CEILING);
    }

}
