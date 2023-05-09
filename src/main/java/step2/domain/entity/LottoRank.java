package step2.domain.entity;

import step2.domain.vo.LottoPrize;

import java.util.List;

public class LottoRank {

    private final List<LottoPrize> lottoPrizes;

    public LottoRank(List<LottoPrize> lottoPrizes) {
        this.lottoPrizes = lottoPrizes;
    }

    public int getLottoRankCount(LottoPrize prize) {
        return (int) lottoPrizes.stream()
                .filter(lottoPrize -> lottoPrize.equals(prize))
                .count();
    }

    public double getTotalRate(int lottoQuantity) {
        double rate = (double) getTotalAmount(lottoPrizes) / getTotalMoney(lottoQuantity);
        return Math.floor(rate * 100.0) / 100.0;
    }

    private long getTotalAmount(List<LottoPrize> lottoPrizes) {
        return lottoPrizes.stream()
                .mapToLong(LottoPrize::getPrize)
                .sum();
    }

    private int getTotalMoney(int quantity) {
        return Lotto.PRICE * quantity;
    }
}
