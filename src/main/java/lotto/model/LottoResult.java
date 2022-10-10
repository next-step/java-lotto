package lotto.model;

import java.util.List;
import java.util.Objects;

public class LottoResult {

    private final int money;
    private final List<Rank> ranks;

    public LottoResult(List<Rank> rewards) {
        this.money = rewards.size() * Lotto.LOTTO_PRICE.getMoney();
        this.ranks = rewards;
    }

    public int countRank(Rank rank) {
        return (int) ranks.stream()
                .filter(ranks -> ranks == rank)
                .count();
    }

    public List<Rank> getRanks() {
        return ranks;
    }
}
