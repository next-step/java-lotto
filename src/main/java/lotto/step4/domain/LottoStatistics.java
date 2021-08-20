package lotto.step4.domain;

import java.util.ArrayList;
import java.util.List;


public class LottoStatistics {
    private List<Rank> statics = new ArrayList<>();

    public long count(Rank rank) {
        return statics.stream().filter(it -> it == rank).count();
    }

    public long reward() {
        return statics.stream().mapToLong(it -> it.getWinningMoney()).sum();
    }

    public LottoStatistics(List<Rank> statics) {
        this.statics = statics;
    }
    public double calculateLottoStatistics(int money) {
        double earningRate = reward() / (double) money;
        return Math.floor(earningRate * 100) / 100.0;
    }
}
