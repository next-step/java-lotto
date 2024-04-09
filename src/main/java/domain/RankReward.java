package domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum RankReward {
    RIGHT_3(3, 5_000, false),
    RIGHT_4(4, 50_000, false),
    RIGHT_5(5, 1_500_000, false),
    BONUS_5(5, 30_000_000, true),
    RIGHT_6(6, 2_000_000_000, false);

    private final int correctCount;
    private final int price;
    private final boolean isBonus;
    private RankReward(int correctCount, int price, boolean isBonus) {
        this.correctCount = correctCount;
        this.price = price;
        this.isBonus = isBonus;
    }

    public static RankReward valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(WinCount(countOfMatch))
                .filter(isBonus(matchBonus))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력값 입니다"));
    }

    private static Predicate<RankReward> isBonus(boolean matchBonus) {
        return rank -> rank.isBonus == matchBonus;
    }

    private static Predicate<RankReward> WinCount(int countOfMatch) {
        return rank -> rank.correctCount == countOfMatch;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrice() {
        return price;
    }
}
