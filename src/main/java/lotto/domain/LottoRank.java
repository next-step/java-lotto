package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    NONE(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    BONUS(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    ;
    private final int correctNum;
    private final int winPrize;

    LottoRank(int correctNum, int winPrize) {
        this.correctNum = correctNum;
        this.winPrize = winPrize;
    }

    public static LottoRank findRank(Integer correctNum, boolean matchBonus) {
        LottoRank rankWithOutBonus = findRankWithOutBonus(correctNum);

        if (checkBonusCondition(matchBonus, rankWithOutBonus)) {
            return LottoRank.BONUS;
        }
        return rankWithOutBonus;
    }

    private static LottoRank findRankWithOutBonus(Integer correctNum) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.correctNum == correctNum)
                .findFirst()
                .orElseGet(() -> NONE);
    }

    private static boolean checkBonusCondition(boolean matchBonus, LottoRank rankWithOutBonus) {
        return LottoRank.SECOND.equals(rankWithOutBonus) && matchBonus;
    }




    public int getCorrectNum() {
        return correctNum;
    }

    public int getWinPrize() {
        return winPrize;
    }
}
