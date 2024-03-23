package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private int lottoCount;
    private int winningMoney;

    LottoRank(int lottoCount, int winningMoney) {
        this.lottoCount = lottoCount;
        this.winningMoney = winningMoney;
    }

    public static LottoRank findLottoRankByLottoCount(int lottoCount, boolean matchBonusNumber) {
        if (lottoCount == LottoRank.SECOND.lottoCount && matchBonusNumber) {
            return LottoRank.SECOND;
        }

        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.lottoCount == lottoCount && rank != SECOND)
                .findFirst()
                .orElse(null);
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public String getResultString() {
        return resultString;
    }

}
