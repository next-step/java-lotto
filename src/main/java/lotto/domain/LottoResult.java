package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private Map<Rank, Integer> matchResult = new HashMap<>();


    public LottoResult() {
        for (Rank rank : Rank.values()) {
            matchResult.put(rank, 0);
        }
    }

    public void match(LottoBundle lottoBundle, WinningLotto winningLotto) {
        lottoBundle.stream()
                .map(winningLotto::matchRank)
                .forEach(this::putRank);
    }

    private void putRank(Rank rank) {
        matchResult.put(rank, matchResult.getOrDefault(rank, 0) + 1);
    }

    public int getCount(Rank rank) {
        return matchResult.get(rank);
    }
}
