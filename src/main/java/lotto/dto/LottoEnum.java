package lotto.dto;

public enum LottoEnum {

    THREE(3,5_000),
    FOUR(4,50_000),
    FIVE(5,1_500_000),
    SIX(6,2_000_000_000);

    private final int match;
    private final int won;


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
