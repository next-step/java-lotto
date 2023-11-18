package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatics {

    private Map<Integer, Integer> matchingRanks = new HashMap<>();


    public void classifyRankLotto(List<Lotto> lottos, Lotto winningLotto) {
        for (Lotto lotto : lottos) {
            Integer matchingCount = winningLotto.countMatchingWinningLotto(lotto);
            matchingRanks.put(matchingCount, matchCountRanks(matchingCount) + 1);
        }
    }

    public Integer matchCountRanks(int count) {
        return matchingRanks.getOrDefault(count, 0);
    }
}
