package lotto.domain;

import lotto.exception.LottoExceptionMessage;

import java.util.Map;

public class WinningResult {
    private Map<LottoRank, Long> lottoResultByRank;

    private WinningResult(Map<LottoRank, Long> lottoResultByRank) {
        this.lottoResultByRank = lottoResultByRank;
    }

    public static WinningResult of(Map<LottoRank, Long> lottoResultByRank) {
        if (lottoResultByRank == null) {
            throw new IllegalArgumentException(LottoExceptionMessage.RESULT_IS_NULL);
        }
        return new WinningResult(lottoResultByRank);
    }

    public double calculateWinningRate() {
        double buyCount = lottoResultByRank.values()
                .stream()
                .reduce(0L, Long::sum);

        double totalPrize = lottoResultByRank.keySet()
                .stream()
                .map(lottoRank -> lottoRank.getPrize() * lottoResultByRank.get(lottoRank))
                .reduce(0L, Long::sum);

        return totalPrize / (buyCount * BuyCount.DEFAULT_LOTTO_MONEY_UNIT);
    }

    public Long getRankCount(LottoRank rank) {
        return lottoResultByRank.getOrDefault(rank, 0L);
    }
}
