package lottos.domain;

import java.util.Arrays;

public enum LottoPrize {

    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    MISS(0, 0);

    private final int prizeAmount;
    private final int countOfMatches;

    LottoPrize(int prizeAmount, int countOfMatches) {
        this.prizeAmount = prizeAmount;
        this.countOfMatches = countOfMatches;
    }

    public static LottoPrize valueOf(final int countOfMatches, final boolean matchBonus) {
        if (countOfMatches != 5) {
            return Arrays.stream(LottoPrize.values())
                    .filter(prize -> prize.countOfMatches == countOfMatches)
                    .findAny()
                    .orElse(LottoPrize.MISS);
        }
        if (matchBonus) {
            return LottoPrize.SECOND;
        }
        return LottoPrize.THIRD;
    }

    public int getCountOfMatches() {
        return countOfMatches;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public boolean isWinning() {
        return this.prizeAmount > 0;
    }

    public boolean isBonus() {
        return this.equals(LottoPrize.SECOND);
    }
}
