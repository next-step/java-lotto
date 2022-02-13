package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Rankings {

    private final List<Ranking> rankings;

    public Rankings(List<Ranking> rankings) {
        this.rankings = rankings;
    }

    public int countWinnerPriceSum() {
        return rankings.stream()
            .map(Ranking::getWinnerPrice)
            .reduce(0, Integer::sum);
    }

    public Map<Ranking, Integer> countFrequency() {
        Map<Ranking, Integer> successSum = new EnumMap<>(Ranking.class);
        for (Ranking ranking : rankings) {
            successSum.put(ranking, successSum.getOrDefault(ranking, 0) + 1);
        }
        return successSum;
    }

    public List<Ranking> getRankings() {
        return rankings;
    }
}
