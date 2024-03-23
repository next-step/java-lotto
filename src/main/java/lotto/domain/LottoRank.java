package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2000000000, "6개 일치 (2000000000원)-"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치(30000000원)-"),
    THIRD(5, 1500000, "5개 일치 (1500000원)-"),
    FOURTH(4, 50000, "4개 일치 (5000원)-"),
    FIFTH(3, 5000, "3개 일치 (5000원)-");

    private int lottoCount;
    private int winningMoney;
    private String resultString;

    LottoRank(int lottoCount, int winningMoney, String resultString) {
        this.lottoCount = lottoCount;
        this.winningMoney = winningMoney;
        this.resultString = resultString;
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

    public int getWinningMoney() {
        return winningMoney;
    }

    public String getResultString() {
        return resultString;
    }

}
