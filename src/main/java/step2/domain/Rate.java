package step2.domain;

import java.util.Map;

public class Rate {

    public static float calculateRate(Map<Match, Integer> numberOfMatches, int price) {
        float totalMoney = 0;

        for (Match match : numberOfMatches.keySet()) {
            int count = numberOfMatches.get(match);
            totalMoney += calculateMoney(match, count);
        }

        float rate = totalMoney / price;
        return roundOffRate(rate);
    }

    private static int calculateMoney(Match match, int count) {
        return count * WinningMoney.winningMoney(match.getMatch());
    }

    private static float roundOffRate(float rate) {
        return (float) Math.floor(rate * 100) / 100;
    }
}
