package lotto.util;

import java.util.Map;

import static lotto.util.Price.LOTTO_PRICE;

public class Reporter {
    public static float getROI(Map<Integer, Integer> matchNums, int totalLottos) {
        if (totalLottos == 0) {
            return 0;
        }

        long result = 0;
        for (Prize prize : Prize.values()) {
            result += (long) prize.money() * matchNums.getOrDefault(prize.number(), 0);
        }

        return (float) result / (totalLottos * LOTTO_PRICE);
    }
}
