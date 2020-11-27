package lotto.automatic.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> rankResult;

    public LottoResult(List<Lotto> lottoList, Lotto winnerLotto) {
        rankResult = new HashMap<>();

        for (LottoRank rank : LottoRank.values()) {
            rankResult.put(rank, 0);
        }

        for (Lotto lotto : lottoList) {
            LottoRank lottoRank = LottoRank.matchCount(lotto.matchCount(winnerLotto));

            rankResult.replace(lottoRank, rankResult.get(lottoRank) + 1);
        }
    }

    public int getRankCount(LottoRank rank) {
        return rankResult.get(rank);
    }

    public long getEarningMoney() {

        long sum = 0;

        for (Map.Entry<LottoRank, Integer> set : rankResult.entrySet()) {
            sum += set.getKey().earningMoney * set.getValue();
        }

        return sum;
    }
}
