package lotto.domain;

import java.util.List;

public class Rankings {
    private static final int ZERO = 0;

    private final List<Ranking> rankings;

    public Rankings(List<Ranking> rankings) {
        this.rankings = rankings;
    }

    public static Rankings of(List<Ranking> rankings) {
        return new Rankings(rankings);
    }

    public long rankingCount(Ranking ranking) {
        return rankings.stream()
                .filter(ranking::equals)
                .count();
    }

    public List<Ranking> getRankings() {
        return rankings;
    }

    public int totalPrizeMoney() {
        return rankings.stream()
                .mapToInt(Ranking::getPrizeMoney)
                .reduce(ZERO, Integer::sum);
    }
}
