package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.type.Match;

import java.util.List;
import java.util.stream.Collectors;

public class LottoStatistics {

    private final int quantity;
    private final List<Match> store;

    public LottoStatistics(List<Match> types) {
        this.quantity = types.size();
        store = types.stream()
                .filter(Match::hasReward)
                .collect(Collectors.toList());
    }

    public String profit() {
        long prize = getAllRewards();
        if (prize == 0) {
            return "0";
        }

        return String.format("%.2f", prize / (Lotto.PRICE * (double) quantity));
    }

    private long getAllRewards() {
        long sum = 0;
        for (Match match : store) {
            sum += match.reward();
        }

        return sum;
    }

    public int getMatchCount(Match type) {
        return (int) store.stream().
                filter(t -> t.name().equals(type.name()))
                .count();
    }
}
