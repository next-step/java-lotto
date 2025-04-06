package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<LottoPrize, Integer> lottoPrizes;
    private final double rate;

    public LottoResult(Map<LottoPrize, Integer> lottoPrizes, double rate) {
        this.lottoPrizes = lottoPrizes;
        this.rate = rate;
    }

    public Map<LottoPrize, Integer> getLottoPrizes() {
        return lottoPrizes;
    }

    public double getRate() {
        return rate;
    }
}
