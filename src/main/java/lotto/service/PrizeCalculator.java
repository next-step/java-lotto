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

        for (Map.Entry<LottoRank, Long> entry: result.entrySet()) {
            wholePrize += entry.getKey().getPrize() * entry.getValue();
        }

        return wholePrize;
    }
}
