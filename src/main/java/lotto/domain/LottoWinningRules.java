package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/*TODO Enum으로 구현해보기*/


public class LottoWinningRules {
    private static final int LOSE_PRIZE = 0;

    private final Map<Integer, Integer> lottoPrize = new HashMap<>();

    public LottoWinningRules() {
        lottoPrize.put(3, 5_000);
        lottoPrize.put(4, 50_000);
        lottoPrize.put(5, 1_500_000);
        lottoPrize.put(6, 2_000_000_000);
    }

    public boolean isWinLotto(int numberOfMatching) {
        return lottoPrize.containsKey(numberOfMatching);
    }

    public int getPrizeOf(int numberOfMatching) {
        if (isWinLotto(numberOfMatching)) {
            return lottoPrize.get(numberOfMatching);
        }
        return LOSE_PRIZE;
    }

    public Set<Integer> numberOfMatchingSet() {
        return lottoPrize.keySet();
    }
}
