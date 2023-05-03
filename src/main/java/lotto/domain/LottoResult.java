package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Lottos lottos;
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;
    private final Map<LottoPrize, Long> prizeCountMap;

    public LottoResult(Lottos lottos, Lotto winningLotto, LottoNumber bonusNumber) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
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
                .map(it -> LottoPrize.from(
                                getMatchingLottoSameNumberCount(it),
                                it.hasNumber(bonusNumber)
                        )
                )
                .filter(it -> it == lottoPrize)
                .count();
    }

    private int getMatchingLottoSameNumberCount(Lotto lotto) {
        return (int) lotto.getLottoNumberSet()
                .stream()
                .filter(winningLotto::hasNumber)
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
