package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoPrize, Integer> winningCountsByPrize = new HashMap<>();

    public void countUp(LottoPrize lottoPrize) {
        winningCountsByPrize.put(lottoPrize, winningCountsByPrize.getOrDefault(lottoPrize, 0) + 1);
    }
}
