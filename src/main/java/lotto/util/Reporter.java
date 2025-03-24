package lotto.util;

import java.util.Map;

import static lotto.util.Price.LOTTO_PRICE;

public class Reporter {
    public final static Map<Integer, Integer> prizes = Map.of(
            3, 5000,
            4, 50000,
            5, 1500000,
            6, 2000000000
    );

    public static float getROI(Map<Integer, Integer> matchNums, int totalLottos) {
        if (totalLottos == 0)
            return 0;

        long result = 0;
        for (int i = 3; i <= 6; i++) {
            result += (long) prizes.get(i) * matchNums.getOrDefault(i, 0);
        }
        return (float) result / (totalLottos * LOTTO_PRICE);
    }
}
