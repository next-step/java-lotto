package lotto.enums;

import lotto.vo.LottoMatchResult;
import lotto.vo.Money;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5,  false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    FAIL(0, false, 0);

    private final int matchCount;
    private final boolean checkBonusNumber;
    private final Money prizeMoney;

    LottoRank(int matchCount, boolean checkBonusNumber, long prizeMoney) {
        this.matchCount = matchCount;
        this.checkBonusNumber = checkBonusNumber;
        this.prizeMoney = new Money(prizeMoney);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getPrizeMoney() {
        return prizeMoney;
    }

    public static LottoRank getRankOf(LottoMatchResult lottoResult) {
        return Arrays.asList(LottoRank.values()).stream()
                .filter(lottoRank -> lottoRank.isLottoMatchResultMatch(lottoResult))
                .findFirst()
                .orElse(FAIL);
    }

    private boolean isLottoMatchResultMatch(LottoMatchResult result) {
        int matchCountOfResult = result.getMatchCount();
        boolean isMatchCountMatch = (this.matchCount == matchCountOfResult);

        if (!this.checkBonusNumber) {
            return isMatchCountMatch;
        }

        return isMatchCountMatch && result.isBonusNumberMatch();
    }

    public Money getTotalPrizeMoneyOfLottoRank(long lottoRankCount) {
        return this.prizeMoney.multiply(lottoRankCount);
    }
}
