package lotto;

import java.util.Arrays;

public enum LottoWin {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 30000000),
    THIRD_PLACE(5, 1500000),
    FOURTH_PLACE(4, 50000),
    FIFTH_PLACE(3, 5000),
    LAST_PLACE(0, 0);

    private final int matchNum;
    private final int winPrice;

    LottoWin(int matchNum, int winPrice) {
        this.matchNum = matchNum;
        this.winPrice = winPrice;
    }

    public int matchNum() {
        return this.matchNum;
    }

    public int winPrice() {
        return this.winPrice;
    }

    public static LottoWin valueOf(int matchNum, boolean matchBonus) {
        return Arrays.stream(LottoWin.values())
                .filter(v -> {
                    return lottoWinBonusFilter(v, matchNum, matchBonus);
                }).findFirst()
                .orElse(LAST_PLACE);
    }

    private static boolean lottoWinBonusFilter(LottoWin lottoWin, int matchNum, boolean matchBonus) {
        if (lottoWin == SECOND_PLACE) {
            return matchNum == lottoWin.matchNum && matchBonus;
        }
        if (lottoWin == THIRD_PLACE) {
            return matchNum == lottoWin.matchNum && !matchBonus;
        }
        return matchNum == lottoWin.matchNum;
    }
}
