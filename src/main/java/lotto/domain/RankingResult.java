package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class RankingResult {
    private final Map<Ranking, Integer> winningLottoMap;

    public RankingResult(Map<Ranking, Integer> winningLottoMap) {
        this.winningLottoMap = winningLottoMap;
    }

    public Money calculateProfit() {
        return new Money(winningLottoMap.keySet()
                .stream().map(ranking -> ranking.getMoney() * winningLottoMap.get(ranking))
                .mapToInt(i -> i)
                .sum());
    }

    public Map<Ranking, Integer> getWinningLottoMap() {
        return Collections.unmodifiableMap(winningLottoMap);
    }

    public int findRankingCount(Ranking ranking) {
        return winningLottoMap.get(ranking);
    }
}
