package lotto.domain;

public enum LottoPrize {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FORTH(3, 5000),
    FIFTH(2, 0),
    SIXTH(1, 0),
    SEVENTH(0, 0);

    private int matchCount;

    private int prize;

    LottoPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoPrize getEnumNameByIntValue(int matchCount){
        LottoPrize result = null;

        for(LottoPrize prize : LottoPrize.values()){
            if (prize.matchCount == matchCount) {
                result = prize;
                break;
            }
        }

        return result;
    }

    public int getPrize() {
        return prize;
    }
}
