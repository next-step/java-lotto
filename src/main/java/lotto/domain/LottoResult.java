package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final double returnRate;
    private final Map<Match, Integer> matchCount;

    public LottoResult(double returnRate, Map<Match, Integer> matchCount) {
        this.returnRate = returnRate;
        this.matchCount = matchCount;
    }

    public static LottoResult from(int price, Matches matches) {
        Map<Match, Integer> matchCount = listToMap(matches.getMatches());
        double returnRate = calculateReturnRate(price, matchCount);
        return new LottoResult(returnRate, matchCount);
    }

    private static <T> Map<T, Integer> listToMap(List<T> list) {
        Map<T, Integer> map = new HashMap<>();
        list.forEach(value -> {
            int count = map.getOrDefault(value, 0);
            map.put(value, count + 1);
        });
        return map;
    }

    private static double calculateReturnRate(int price, Map<Match, Integer> matchCount) {
        return (double) calculateTotalPrize(matchCount) / price;
    }

    private static Long calculateTotalPrize(Map<Match, Integer> lottoPrizeCount) {
        return lottoPrizeCount.entrySet().stream()
                .map(entry -> entry.getKey().getPrize() * entry.getValue())
                .reduce(0L, Long::sum);
    }

    public int getMatchCount(Match match) {
        return matchCount.getOrDefault(match, 0);
    }

    public double getReturnRate() {
        return returnRate;
    }
}
