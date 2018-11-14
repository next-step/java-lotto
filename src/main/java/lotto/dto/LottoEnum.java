package lotto.dto;

public enum LottoEnum {

    THREE(3,5000),
    FOUR(4,50000),
    FIVE(5,1500000),
    SIX(6,2000000000);

    final private int match;
    final private int won;


    LottoEnum(int match, int won) {
        this.match = match;
        this.won = won;
    }

    public int getMatch() {
        return match;
    }

    public int getWon() {
        return won;
    }
}
