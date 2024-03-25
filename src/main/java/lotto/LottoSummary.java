package lotto;

import java.util.List;


public class LottoSummary implements LottoStatistics{

    private final List<Rank> ranks;
    private final Money paidMoney;

    public LottoSummary(List<Rank> ranks, Money paidMoney) {
        this.ranks = ranks;
        this.paidMoney = paidMoney;
    }

    @Override
    public float rateOfReturn() {
        Long priceSum = ranks.stream()
                .map(Rank::getWinPrice)
                .mapToLong(a -> a)
                .sum();

        return (float) (Math.floor(priceSum.floatValue() / paidMoney.getMoney() * 100.0f) / 100.0f);
    }

    public int getRankCount(Rank rank) {
        return (int) ranks.stream()
                .filter(it -> rank == it)
                .count();
    }
}
