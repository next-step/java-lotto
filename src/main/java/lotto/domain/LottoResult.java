package lotto.domain;

import java.util.List;

/**
 * Created by wyparks2@gmail.com on 2019-06-26
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class LottoResult {
    private List<LottoRank> lottoRanks;

    public LottoResult(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public long match(LottoRank lottoRank) {
        return lottoRanks.stream()
                .filter(rank -> rank == lottoRank)
                .count();
    }

    public double calculateYields() {
        if (lottoRanks.isEmpty()) {
            return 0;
        }

        int purchasedTotal = lottoRanks.size() * 1000;
        int prizesTotal = lottoRanks.stream()
                .map(LottoRank::getPrizes)
                .reduce(0, Integer::sum);

        return prizesTotal / purchasedTotal;
    }
}
