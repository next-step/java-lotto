package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0),
    ;

    private final int countOfMatch;
    private final int prize;

    private LottoRank(int countOfMatch, int prize) {
        this.countOfMatch = countOfMatch;
        this.prize = prize;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrize() {
        return prize;
    }

    public int calculatePrize(int count) {
        return this.prize * count;
    }

    public static LottoRank valueOf(int countOfMatch, boolean matchBonus) {

        if (isSecondRank(countOfMatch, matchBonus)) {
            return LottoRank.SECOND;
        }

        if (THIRD.countOfMatch == countOfMatch) {
            return LottoRank.THIRD;
        }

        return Arrays.stream(values())
                .filter(value -> value.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(MISS);
    }

    private static boolean isSecondRank(int countOfMatch, boolean matchBonus) {
        return SECOND.countOfMatch == countOfMatch && matchBonus;
    }
}
