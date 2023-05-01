package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static final int MINIMUM_WINNING_COUNT = 3;

    private final Lottos lottos;
    private final Lotto winningLotto;
    private final Map<LottoPrize, Long> prizeCountMap;

    public LottoResult(Lottos lottos, Lotto winningLotto) {
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
                .map(this::getMatchingLottoSameNumberCount)
                .filter(it -> it == lottoPrize.getMatchingCount())
                .count();
    }

    private long getMatchingLottoSameNumberCount(Lotto lotto) {
        return lotto.getLottoNumberSet()
                .stream()
                .filter(winningLotto::hasNumber)
                .count();
    }

    public long getMatchingLottosCount(LottoPrize lottoPrize) {
        return prizeCountMap.get(lottoPrize);
    }

    public double getProfitRate() {
        long price = 0;
        for (int i = MINIMUM_WINNING_COUNT; i <= Lotto.LOTTO_NUMBER_SIZE; i++) {
            LottoPrize lottoPrize = LottoPrize.from(i);
            price += lottoPrize.getPrize() * getMatchingLottosCount(lottoPrize);
        }
        return price / (double) (lottos.getLottoQuantity() * LottoShop.LOTTO_PRICE);
    }
}
