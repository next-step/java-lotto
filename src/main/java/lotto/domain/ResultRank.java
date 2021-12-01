package lotto.domain;

import java.util.Map;

public class ResultRank {
    private final Map<Rank, Long> rank;

    public ResultRank(Map<Rank, Long> rank) {
        this.rank = rank;
    }

    public double getRate(int purchaseLottoMoney) {
        return (double) this.getPrizeMoney() / purchaseLottoMoney;
    }

    public Long getPrizeCount(Rank rank) {
        return this.rank.getOrDefault(rank, 0L);
    }
    
    private long getPrizeMoney() {
        return rank.keySet().stream()
                .map(Rank::getPrizeMoney)
                .reduce(0, Integer::sum);
    }
}
