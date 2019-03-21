package lotto.enums;

import lotto.vo.LottoMatchResult;
import lotto.vo.LottoWinResult;
import lotto.vo.Money;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    FAIL(0, 0);

    private int matchCount;
    private Money prizeMoney;

    LottoRank(int matchCount, long prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = new Money(prizeMoney);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrizeMoney() {
        return prizeMoney.getAmount();
    }

    public static LottoRank getRank(LottoMatchResult lottoResult) {
        if (SECOND.getMatchCount() == lottoResult.getMatchCount()) {
            return (lottoResult.isBonusNumberMatch() ? SECOND : THIRD);
        }

        return Arrays.asList(LottoRank.values()).stream()
                .filter(lottoRank -> (lottoRank.matchCount == lottoResult.getMatchCount()))
                .findFirst()
                .orElse(FAIL);
    }

    public long getTotalPrizeMoneyOfLottoRank(LottoWinResult lottoWinResult) {
        long lottoRankCount = lottoWinResult.getLottoRankCount(this);
        return this.getPrizeMoney() * lottoRankCount;
    }
}
