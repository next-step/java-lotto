package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final List<LottoPrize> lottoPrizeList;

    public LottoResult(List<LottoPrize> lottoPrizeList) {
        this.lottoPrizeList = lottoPrizeList;
    }

    public Map<Integer, Integer> matchResult() {
        Map<Integer, Integer> result = new HashMap<>();
        lottoPrizeList.stream().filter(lottoPrize -> lottoPrize != LottoPrize.MISS)
                .forEach(lottoPrize -> {
                    result.put(lottoPrize.getCountOfMatch(), result.getOrDefault(lottoPrize.getCountOfMatch(),0) + 1);
                });

        return result;
    }

    public double statistics(int money) {
        double profit = lottoPrizeList.stream()
                                .mapToDouble(LottoPrize::getPrize)
                                .sum();
        return Math.round((profit / money) * 100) / 100.0;
    }
}
