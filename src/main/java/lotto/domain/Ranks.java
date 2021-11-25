package lotto.domain;

import lotto.domain.enums.Rank;

import java.util.List;

public class Ranks {

    private final List<Rank> rank;

    public Ranks(List<Rank> rank) {
        this.rank = rank;
    }

    public int countRankOf(Rank first) {
        return (int) rank.stream()
                .filter(first::equals)
                .count();
    }

    public double calculateRateOfProfit() {
        return ((int)(rank.stream()
                .mapToInt(Rank::getPrize)
                .sum() / (rank.size() * 1000d) * 100)) / 100d;
    }

}
