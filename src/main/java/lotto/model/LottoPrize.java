package lotto.model;

public enum LottoPrize {

    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private int matchs;
    private int prize;

    LottoPrize(int matchs, int prize) {
        this.matchs = matchs;
        this.prize = prize;
    }

    public static LottoPrize checkWithMatchsAndBonusMatch(int matchs, boolean bonusMatch) {
        LottoPrize prize = null;
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            if (lottoPrize.getMatchs() == matchs) {
                prize = lottoPrize;
                break;
            }
        }
        if (LottoPrize.THIRD.equals(prize) && bonusMatch) {
            prize = LottoPrize.SECOND;
        }
        return prize;
    }

    public int getMatchs() {
        return matchs;
    }

    public int getPrize() {
        return prize;
    }


}
