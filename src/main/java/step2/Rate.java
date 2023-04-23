package step2;

import java.util.Map;

public class Rate {

    public static float calculateRate(Map<Integer, Integer> numberOfMatches, int price) {
        float totalMoney = 0;

        for (Integer match : numberOfMatches.keySet()) {
            int count = numberOfMatches.get(match);
            totalMoney += calculateMoney(match, count);
        }

        float rate = totalMoney / price;
        return roundOffRate(rate);
    }

    private static float roundOffRate(float rate) {
        return (float) Math.floor(rate * 100) / 100;
    }

    private static int calculateMoney(int match, int count) {
        if (match == 3) {
            return count * 5000;
        }
        if (match == 4) {
            return count * 50000;
        }
        if (match == 5) {
            return count * 1500000;
        }
        if (match == 6) {
            return count * 2000000000;
        }

        return 0;
    }
}
