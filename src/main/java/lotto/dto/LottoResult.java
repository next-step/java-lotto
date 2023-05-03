package lotto.dto;

import lotto.domain.Matches;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private final double returnRate;
    private final Map<LottoPrize, Integer> lottoPrizeCount;

    public LottoResult(double returnRate, Map<LottoPrize, Integer> lottoPrizeCount) {
        this.returnRate = returnRate;
        this.lottoPrizeCount = lottoPrizeCount;
    }

    public static LottoResult from(int price, Matches matches) {
        List<LottoPrize> prizes = matches.getMatches().stream()
                .map(LottoPrize::from)
                .collect(Collectors.toList());
        Map<LottoPrize, Integer> lottoPrizeCount = listToMap(prizes);
        double returnRate = calculateReturnRate(price, lottoPrizeCount);
        return new LottoResult(returnRate, lottoPrizeCount);
    }

    private static <T> Map<T, Integer> listToMap(List<T> list) {
        Map<T, Integer> map = new HashMap<>();
        list.forEach(value -> {
            int count = map.getOrDefault(value, 0);
            map.put(value, count + 1);
        });
        return map;
    }

    private static double calculateReturnRate(int price, Map<LottoPrize, Integer> lottoPrizeCount) {
        return (double) calculateTotalPrize(lottoPrizeCount) / price;
    }

    private static Long calculateTotalPrize(Map<LottoPrize, Integer> lottoPrizeCount) {
        return lottoPrizeCount.entrySet().stream()
                .map(entry -> entry.getKey().getPrize() * entry.getValue())
                .reduce(0L, Long::sum);
    }

    public int getLottoPrizeCount(LottoPrize lottoPrize) {
        return lottoPrizeCount.getOrDefault(lottoPrize, 0);
    }

    public double getReturnRate() {
        return returnRate;
    }
}
