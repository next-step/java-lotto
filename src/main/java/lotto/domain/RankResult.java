package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class RankResult {

    private static final int INITIAL_VALUE = 0;
    private final Map<Rank, Integer> rankResult;


    public RankResult(final Lottos lottos, final Winning winning) {
        this.rankResult = rankCount(lottos, winning);
    }

    public Map<Rank, Integer> getRankResult() {
        return rankResult;
    }

    public Money getTotalPrize() {
        return new Money(rankResult.entrySet().stream()
            .mapToInt(entry -> entry.getKey().getPrize(entry.getValue()).getValue())
            .sum());
    }

    public HashMap<Rank, Integer> rankCount(final Lottos lottos, final Winning winning) {
        HashMap<Rank, Integer> rankResult = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankResult.put(rank, INITIAL_VALUE);
        }

        for (Lotto lotto : lottos.lottos()) {
            Rank rank = Rank.countMatch(winning, lotto);
            rankResult.put(rank, rankResult.get(rank) + 1);
        }
        return rankResult;
    }
}
