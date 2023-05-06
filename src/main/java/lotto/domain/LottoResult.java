package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Lottos lottos;
    private final WinningLotto winningLotto;
    private final Map<LottoPrize, Long> prizeCountMap;

    public LottoResult(Lottos lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        prizeCountMap = initializePrizeCountMap();
    }

    private Map<LottoPrize, Long> initializePrizeCountMap() {
        Map<LottoPrize, Long> result = new HashMap<>();

        Arrays.stream(LottoPrize.values())
                .forEach(it -> result.put(it, calculateMatchingLottosCount(it)));

        return result;
    }

    private long calculateMatchingLottosCount(LottoPrize lottoPrize) {
        return lottos.getLottoList()
                .stream()
                .map(winningLotto::getMatchResult)
                .filter(it -> it == lottoPrize)
                .count();
    }

    public long getMatchingLottosCount(LottoPrize lottoPrize) {
        return prizeCountMap.get(lottoPrize);
    }

    public double getProfitRate() {
        long totalPrize = Arrays.stream(LottoPrize.values())
                .mapToLong(it -> it.getTotalPrize(getMatchingLottosCount(it)))
                .sum();

        return totalPrize / (double) (lottos.getLottoQuantity() * LottoShop.LOTTO_PRICE);
    }
}
