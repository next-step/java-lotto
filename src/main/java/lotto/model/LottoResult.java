package lotto.model;

import java.util.List;
import java.util.Objects;

public class LottoResult {
    private final List<LottoPrize> lottoPrizes;

    public LottoResult(List<LottoPrize> lottoPrizes) {
        this.lottoPrizes = lottoPrizes;
    }

    public int calculateProfit(){
        int profit = 0;
        for (LottoPrize prize : lottoPrizes) {
            profit += prize.getAmount();
        }
        return profit;
    }

    public int getPrizeCount(LottoPrize prize) {
        return (int) lottoPrizes.stream()
            .filter(p -> p.equals(prize))
            .count();
    }

    public double calculateReturnRate() {
        double returnRate = (double) calculateProfit() / (lottoPrizes.size() * LottoShop.LOTTO_PRICE);
        return Math.floor(returnRate * 100) / 100.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoResult that = (LottoResult) o;
        return lottoPrizes.equals(that.lottoPrizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoPrizes);
    }
}
