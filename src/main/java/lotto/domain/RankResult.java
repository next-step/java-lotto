package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class RankResult {

    private static final int INITIAL_VALUE = 0;
    private Map<Rank, Integer> rankResult;
    private final Lottos lottos;
    private final Winning winning;


    public RankResult(Lottos lottos, Winning winning) {
        this.lottos = lottos;
        this.winning = winning;
        this.rankResult = rankCount(this.lottos,this.winning);
    }

    public Map<Rank, Integer> getRankResult() {
        return rankResult;
    }

    public Money getTotalPrize() {
        return new Money(rankResult.entrySet().stream()
            .mapToInt(entry -> entry.getKey().getPrize(entry.getValue()).getValue())
            .sum());
    }

    public HashMap<Rank, Integer> rankCount(Lottos lottos, Winning winning) {
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
