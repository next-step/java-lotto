package domain;

import java.util.Arrays;

public enum Jackpot {
    SAME_0_NUMBERS(0, 0),
    SAME_1_NUMBERS(1, 0),
    SAME_2_NUMBERS(2, 0),
    SAME_3_NUMBERS(3, 5_000),
    SAME_4_NUMBERS(4, 50_000),
    SAME_5_NUMBERS(5, 1_500_000),
    SAME_6_NUMBERS(6, 2_000_000_000);

    private int matchCount;
    private int prizeMoney;

    Jackpot(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Jackpot valueOf(int matchCount) {
        return Arrays.stream(Jackpot.values())
                .filter(jackpot -> jackpot.isSameMatchCount(matchCount))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 데이터가 입력되었습니다."));
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public int getTotalPrizeMoney(int sameCount) {
        return this.prizeMoney * sameCount;
    }

    public boolean isSameMatchCount(int key) {
        return this.matchCount == key;
    }
}
