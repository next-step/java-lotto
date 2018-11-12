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

    private int matchNumber;
    private int prizeMoney;

    Jackpot(int matchNumber, int prizeMoney) {
        this.matchNumber = matchNumber;
        this.prizeMoney = prizeMoney;
    }

    public static Jackpot valueOf(int matchCount) {
        return Arrays.stream(Jackpot.values())
                .filter(jackpot -> jackpot.isSameMatchNumber(matchCount))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 데이터가 입력되었습니다."));
    }

    public int getMatchNumber() {
        return this.matchNumber;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public int getTotalPrizeMoney(int sameCount) {
        return this.prizeMoney * sameCount;
    }

    public boolean isSameMatchNumber(int matchNumber) {
        return this.matchNumber == matchNumber;
    }
}
