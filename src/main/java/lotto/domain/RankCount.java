package lotto.domain;

import java.util.HashMap;

public class RankCount {

    private static final int INITIAL_VALUE = 0;
    private static final int INCREMENT = 1;
    private final Lottos lottos;
    private final Winning winning;

    public RankCount(final Lottos lottos, final Winning winning) {
        this.lottos = lottos;
        this.winning = winning;
    }

    public HashMap<Rank, Integer> rankCount(){
        HashMap<Rank, Integer> result = new HashMap<>();
        for(Rank rank : Rank.values()){
            result.put(rank, INITIAL_VALUE);
        }

        for(Lotto lotto: lottos.lottos()){
            Rank rank = Rank.countMatch(winning, lotto);
            result.put(rank, result.get(rank) + INCREMENT);
        }
        return result;
    }
}
