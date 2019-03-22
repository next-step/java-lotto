package lotto.enums;

import lotto.vo.LottoMatchResult;
import lotto.vo.Money;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, BonusNumberMatchOption.NOT, 2_000_000_000),
    SECOND(5, BonusNumberMatchOption.MUST, 30_000_000),
    THIRD(5,  BonusNumberMatchOption.NOT, 1_500_000),
    FOURTH(4, BonusNumberMatchOption.OPTIONAL, 50_000),
    FIFTH(3, BonusNumberMatchOption.OPTIONAL, 5_000),
    FAIL(0, BonusNumberMatchOption.OPTIONAL, 0);

    private final int matchCount;
    private final BonusNumberMatchOption bonusNumberMatchOption;
    private final Money prizeMoney;

    LottoRank(int matchCount, BonusNumberMatchOption bonusNumberMatchOption, long prizeMoney) {
        this.matchCount = matchCount;
        this.bonusNumberMatchOption = bonusNumberMatchOption;
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
        boolean isBonusNumberMatch = result.isBonusNumberMatch();

        return this.matchCount == matchCountOfResult &&
                this.bonusNumberMatchOption.bonusNumberMatchCheck(isBonusNumberMatch);
    }

    public Money getTotalPrizeMoneyOfLottoRank(long lottoRankCount) {
        return this.prizeMoney.multiply(lottoRankCount);
    }
}
