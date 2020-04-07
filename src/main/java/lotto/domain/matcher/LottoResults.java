package lotto.domain.matcher;

import java.math.BigDecimal;
import java.util.List;

import static lotto.domain.Constant.PRICE_PER_GAME;

public class LottoGameResults {
    private static final int SCALE_TWO = 2;
    private final List<LottoRank> lottoRanks;

    LottoGameResults(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public BigDecimal getProfitRate() {
        return getWinningPrizeSum().divide(getPaidMoney(), SCALE_TWO, BigDecimal.ROUND_CEILING);
    }

    public long getEachRankCountTotal(LottoRank lottoRank) {
        return lottoRanks.stream()
                .filter(lotto -> lotto.equals(lottoRank))
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
