package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

import static lotto.domain.Constant.PRICE_PER_GAME;

public class LottoGameResults {
    private final List<LottoRank> lottoRanks;

    LottoGameResults(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public BigDecimal getProfitRate() {
        return getWinningPrizeSum().divide(getPaidMoney());
    }

    public long getEachRankCountTotal(int matchCount) {
        return lottoRanks.stream()
                .filter(lottoRank -> lottoRank.isEqualTo(matchCount))
                .count();
    }

    BigDecimal getWinningPrizeSum() {
        return BigDecimal.valueOf(lottoRanks.stream()
                .mapToInt(LottoRank::getWinningPrize)
                .sum());
    }

    private BigDecimal getPaidMoney() {
        return BigDecimal.valueOf(lottoRanks.size() * PRICE_PER_GAME);
    }

}
