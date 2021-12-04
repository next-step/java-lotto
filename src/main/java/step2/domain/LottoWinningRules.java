package step2.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LottoWinningRules {
    private static final int LOSE_PRIZE = 0;
    private final Map<Integer, Integer> lottoPrize = new HashMap<>();

    public LottoWinningRules() {
        lottoPrize.put(3, 5000);
        lottoPrize.put(4, 50000);
        lottoPrize.put(5, 1500000);
        lottoPrize.put(6, 2000000000);
    }

    public boolean winLotto(int numberOfMatches) {
        return lottoPrize.containsKey(numberOfMatches);
    }

    public int getPrizeOf(int numberOfMatching) {
        return winLotto(numberOfMatching) ? lottoPrize.get(numberOfMatching) : LOSE_PRIZE;
    }

    public Set<Integer> numberOfMatchingSet() {
        return lottoPrize.keySet();
    }
}
