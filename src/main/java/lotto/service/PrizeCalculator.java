package lotto.service;

import lotto.constant.ErrorMessage;
import lotto.domain.LottoRank;

import java.util.Map;

public class PrizeCalculator {
    private PrizeCalculator() {
        throw new IllegalStateException(ErrorMessage.CANNOT_BE_INSTANTIATED.getMessage());
    }

    public static Long getPrize(Map<LottoRank, Long> result) {
        long wholePrize = 0L;

        for (LottoRank lottoRank: result.keySet()) {
            wholePrize += lottoRank.getPrize() * result.get(lottoRank);
        }

        return wholePrize;
    }
}
