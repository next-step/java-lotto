package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Prize {

    private Prize() {
    }

    public static List<Integer> prizeList = Arrays.asList(0, 0, 0, 5_000, 50_000, 1_500_000, 2_000_000_000);

    public static double calculatorYield(List<Integer> matchingList, Integer purchaseAmount) {
        double resultPrize = 0L;
        for (int i = 0; i < matchingList.size(); i++) {
            resultPrize += matchingList.get(i) * prizeList.get(i);
        }
        return (resultPrize / new Double(purchaseAmount));
    }
}
