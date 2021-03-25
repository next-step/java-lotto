package step3.domain;

import java.util.*;

public class LottoStatistic {

    private Map<Rank, Integer> statisticMap = new TreeMap<>(Collections.reverseOrder());
    private Rank rank;

    private void setUp() {
        statisticMap.put(Rank.FIFTH, 0);
        statisticMap.put(Rank.FOURTH, 0);
        statisticMap.put(Rank.SECOND, 0);
        statisticMap.put(Rank.FIRST, 0);
    }

    public Map<Rank, Integer> statistic(Lottos lottos, WinningLotto winningLotto) {
        setUp();
        for (Lotto lotto : lottos.getLottoList()) {
            rank = lotto.match(lotto.getLotto(), winningLotto);
            statisticMap.put(rank, statisticMap.getOrDefault(rank, 0) + 1);
        }

        return statisticMap;
    }
}
