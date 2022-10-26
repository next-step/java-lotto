package lotto.domain;

import lotto.constant.LottoRanking;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {
    private final EnumMap<LottoRanking, Integer> lottoRankings = new EnumMap<>(LottoRanking.class);

    private long award;
    double percentage;

    public LottoResult() {
        for(LottoRanking rank : LottoRanking.values()) {
            this.lottoRankings.put(rank, 0);
        }
    }

    public void calculateLottoResult(ArrayList<LottoRanking> rank, int price){
        for (LottoRanking lottoRanking : rank) {
            lottoRankings.computeIfPresent(lottoRanking, (key, value) -> {
                award += key.getAward();
                return value + 1;
            });
        }
        calculatePercentage(price);
    }

    private void calculatePercentage(int price) {
        this.percentage = ((double) award / price);
    }

    public Map<LottoRanking, Integer> getLottoRankings() {
        return this.lottoRankings;
    }

    public double getPercentage() {
        return this.percentage;
    }
}
