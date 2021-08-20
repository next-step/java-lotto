package lotto.step4.domain;

import java.util.List;


public class LottoStatistics {
    private final List<Rank> statics;

    public LottoStatistics(List<Rank> statics) {
        this.statics = statics;
    }
    public long count(Rank rank) {
        return statics.stream().filter(it -> it == rank).count();
    }

    public long reward() {
        return statics.stream().mapToLong(it -> it.getWinningMoney()).sum();
    }

    public double calculateLottoStatistics() {
        double earningRate = (double) (reward()) / ((double) (countWinningLotteries()) * Money.LOTTO_PRICE);
        return Math.floor(earningRate * 100) / 100.0;
    }

    public int countWinningLotteries(){
        return statics.size();
    }

}
