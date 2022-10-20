package lotto.model;

import java.util.Collections;
import java.util.List;

public class LottoResult {

    private final int money;
    private final List<Rank> ranks;

    public LottoResult(List<Rank> rewards) {
        this.money = Money.LOTTO_PRICE.getTotalMoney(rewards.size());
        this.ranks = rewards;
    }

    public int countRank(Rank rank) {
        return (int) ranks.stream()
                .filter(ranks -> ranks == rank)
                .count();
    }

    public Double calculateYield() {
        return getTotalReward() / (double) money;
    }

    private int getTotalReward() {
        return ranks.stream()
                .map(Rank::getReward)
                .reduce(0, Integer::sum);
    }

    public List<Rank> getRanks() {
        return Collections.unmodifiableList(ranks);
    }
}
