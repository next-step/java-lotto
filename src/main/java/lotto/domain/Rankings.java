package lotto.domain;

import java.util.List;
import java.util.Objects;

import static lotto.domain.LottoStore.LOTTO_PRICE;

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

    public double findProfitRate() {
        return (double) totalPrizeMoney() / (LOTTO_PRICE * rankings.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rankings that = (Rankings) o;
        return Objects.equals(rankings, that.rankings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankings);
    }
}
