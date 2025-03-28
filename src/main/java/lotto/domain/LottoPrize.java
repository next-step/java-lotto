package lotto.domain;

public enum LottoPrize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int match;
    private final int prize;

    LottoPrize(int match, int prize) {
        this.match = match;
        this.prize = prize;
    }

    public static LottoPrize valueOf(int matchCount, boolean isMatchBonus) {
        if (matchCount == SECOND.getMatch()) {
            return isSecond(isMatchBonus);
        }

        LottoPrize returnPrize = MISS;
        for (LottoPrize lottoPrize : values()) {
            returnPrize = getMatched(matchCount, lottoPrize, returnPrize);
        }

        return returnPrize;
    }

    private static LottoPrize getMatched(int matchCount, LottoPrize lottoPrize, LottoPrize returnPrize) {
        if (lottoPrize.getMatch() == matchCount) {
            return lottoPrize;
        }
        return returnPrize;
    }

    private static LottoPrize isSecond(boolean isMatchBonus) {
        return isMatchBonus ? SECOND : THIRD;
    }

    public int getMatch() {
        return match;
    }

    public Integer getPrize() {
        return prize;
    }
}
