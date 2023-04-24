package step2.domain;

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

    private static int calculateMoney(int match, int count) {
        return count * WinningMoney.winningMoney(match);
    }

    private static float roundOffRate(float rate) {
        return (float) Math.floor(rate * 100) / 100;
    }
}
