package lotto.service;

import lotto.domain.LottoRank;

import java.util.Map;

public class PrizeCalculator {
    public static Long getPrize(Map<LottoRank, Long> result) {
        long wholePrize = 0L;

        for (LottoRank lottoRank: result.keySet()) {
            wholePrize += lottoRank.getPrize() * result.get(lottoRank);
        }

        return wholePrize;
    }
}
