package lotto.domain;

import lotto.domain.type.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class LottoStatistics {

    private final int quantity;
    private final List<Rank> result;

    public LottoStatistics(Lottos lottos, Lotto winLotto) {
        this(lottos.match(winLotto));
    }

    public LottoStatistics(List<Rank> types) {
        this.quantity = types.size();
        result = types.stream()
                .filter(Rank::hasWinningMoney)
                .collect(Collectors.toList());
    }

    public double profit() {
        long prize = getAllRewards();
        if (prize == 0) {
            return 0;
        }

        return prize / (Lotto.PRICE * (double) quantity);
    }

    private long getAllRewards() {
        long sum = 0;
        for (Rank rank : result) {
            sum += rank.winningMoney();
        }

        return sum;
    }

    public int getMatchCount(Rank type) {
        return (int) result.stream().
                filter(t -> t.name().equals(type.name()))
                .count();
    }
}
