package domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum RankReward {
    RIGHT_3(3, 5_000, false, 0),
    RIGHT_4(4, 50_000, false, 1),
    RIGHT_5(5, 1_500_000, false, 2),
    BONUS_5(5, 30_000_000, true, 3),
    RIGHT_6(6, 2_000_000_000, false, 4);

    private final int correctCount;
    private final int price;
    private final boolean isBonus;
    private final int index;
    private RankReward(int correctCount, int price, boolean isBonus, int index) {
        this.correctCount = correctCount;
        this.price = price;
        this.isBonus = isBonus;
        this.index = index;
    }

    public static RankReward valueOf(int index, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(WinCount(index))
                .filter(isBonus(matchBonus))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력값 입니다"));
    }

    private static Predicate<RankReward> isBonus(boolean matchBonus) {
        return rank -> rank.isBonus == matchBonus;
    }

    private static Predicate<RankReward> WinCount(int index) {
        return rank -> rank.index == index;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrice() {
        return price;
    }
}
