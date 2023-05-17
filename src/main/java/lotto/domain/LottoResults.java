package lotto.domain;

import java.util.HashMap;

public class LottoResults {

    private final HashMap<LottoRank, Integer> ranks;

    public LottoResults() {
        HashMap<LottoRank, Integer> ranks = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            ranks.put(rank, 0);
        }
        this.ranks = ranks;
    }

    public int findRankResult(LottoRank lottoRank) {
        return ranks.get(lottoRank);
    }

    public void addRank(LottoRank lottoRank) {
        ranks.put(lottoRank, ranks.get(lottoRank) + 1);
    }
}
