package lotto.domain;

import lotto.constant.LottoRanking;

import java.util.*;

public class LottoResult {
    private final EnumMap<LottoRanking, Integer> lottoRankings = new EnumMap<>(LottoRanking.class);

    public LottoResult(EnumMap<LottoRanking, Integer> lottoRankings) {
        for(LottoRanking rank : LottoRanking.values()) {
            this.lottoRankings.put(rank, 0);
        }
       this.lottoRankings.putAll(lottoRankings);
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
