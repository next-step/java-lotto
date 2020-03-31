package lotto.domain;

import java.util.List;

import static lotto.domain.Constant.PRICE_PER_GAME;

public class LottoGameResults {
    private final List<LottoRank> lottoRanks;

    LottoGameResults(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public double getProfitRate() {
        return getWinningPrizeSum() / (double) (lottoRanks.size() * PRICE_PER_GAME);
    }

    public long getEachRankCountTotal(int matchCount) {
        return lottoRanks.stream()
                .filter(lottoRank -> lottoRank.isEqualTo(matchCount))
                .count();
    }

    double getWinningPrizeSum() {
        return lottoRanks.stream()
                .mapToDouble(LottoRank::getWinningPrize)
                .sum();
    }

}
