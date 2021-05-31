package lotto;

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
        if (matchNum == FIRST_PLACE.matchNum) {
            return FIRST_PLACE;
        }
        if (matchNum == SECOND_PLACE.matchNum && matchBonus) {
            return SECOND_PLACE;
        }
        if (matchNum == THIRD_PLACE.matchNum) {
            return THIRD_PLACE;
        }
        if (matchNum == FOURTH_PLACE.matchNum) {
            return FOURTH_PLACE;
        }
        if (matchNum == FIFTH_PLACE.matchNum) {
            return FIFTH_PLACE;
        }
        return LAST_PLACE;
    }
}
