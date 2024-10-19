package lotto;

public enum LottoRankEnum {

    FIRST(2000000000),
    SECOND(0),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private final int prize;

    private LottoRankEnum(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
