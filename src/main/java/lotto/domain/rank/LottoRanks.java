package lotto.domain.rank;

import java.math.BigDecimal;
import java.util.List;

import static lotto.domain.Constant.PRICE_PER_GAME;

public class LottoRanks {
    private static final int SCALE_TWO = 2;
    private final List<LottoRank> lottoRanks;

    private LottoRanks(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public static LottoRanks of(List<LottoRank> lottoRanks) {
        return new LottoRanks(lottoRanks);
    }

    public List<LottoRank> getLottoRanks() {
        return lottoRanks;
    }

    public float getProfitRate() {
        return getWinningPrizeSum()
                .divide(getPaidMoney(), SCALE_TWO, BigDecimal.ROUND_CEILING)
                .floatValue();
    }

    private BigDecimal getWinningPrizeSum() {
        return BigDecimal.valueOf(lottoRanks.stream()
                .mapToInt(LottoRank::getWinningPrize)
                .sum());
    }

    private BigDecimal getPaidMoney() {
        return BigDecimal.valueOf(lottoRanks.size() * PRICE_PER_GAME);
    }

    public long getEachRankCountTotal(LottoRank lottoRank) {
        return lottoRanks.stream()
                .filter(myRank -> myRank.equals(lottoRank))
                .count();
    }
}
