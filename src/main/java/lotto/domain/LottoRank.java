package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, true, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NOT_MATCH(0, false, 0);

    private int matchCount;
    private boolean needCheckBonusNumber;
    private int winning;

    LottoRank(int matchCount, boolean needCheckBonusNumber, int winning) {
        this.matchCount = matchCount;
        this.needCheckBonusNumber = needCheckBonusNumber;
        this.winning = winning;
    }

    public static LottoRank find(long matchCount, BonusNumberStrategy bonusNumberStrategy) {
        LottoRank lottoRank = Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NOT_MATCH);

        if (lottoRank.needCheckBonusNumber) {
            return bonusNumberStrategy.checkBonusNumber(lottoRank);
        }

        return lottoRank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinning() {
        return winning;
    }
}
