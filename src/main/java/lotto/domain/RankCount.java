package lotto.domain;

import java.util.HashMap;

public class RankCount {

    private static final int INITIAL_VALUE = 0;
    private final Lottos lottos;
    private final Winning winning;

    public RankCount(Lottos lottos, Winning winning) {
        this.lottos = lottos;
        this.winning = winning;
    }

    public HashMap<Rank, Integer> rankCount() {
        HashMap<Rank, Integer> result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, INITIAL_VALUE);
        }

        for (Lotto lotto : lottos.lottos()) {
            Rank rank = Rank.countMatch(winning, lotto);
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }
}
