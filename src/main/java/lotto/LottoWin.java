package lotto;

public enum LottoWin {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 1500000),
    THIRD_PLACE(4, 50000),
    FOURTH_PLACE(3, 5000),
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
}
