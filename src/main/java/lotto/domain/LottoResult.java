package lotto.domain;

import lotto.constant.LottoRanking;

import java.util.*;

public class LottoResult {
    private final EnumMap<LottoRanking, Integer> lottoRankings;

    public LottoResult(EnumMap<LottoRanking, Integer> lottoRankings) {
       this.lottoRankings = lottoRankings;
    }

    public double calculatePercentage(int price) {
        double award = 0.0;
        for (LottoRanking lottoRanking : lottoRankings.keySet()) {
            award += lottoRanking.calculateAward(lottoRankings.get(lottoRanking));
        }
        return award / (double) price;
    }

    public Map<LottoRanking, Integer> getLottoRankings() {
        return this.lottoRankings;
    }
}
