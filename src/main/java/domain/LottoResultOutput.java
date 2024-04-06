package domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum LottoResultOutput {
    RIGHT_3(3, 5_000, false),
    RIGHT_4(4, 50_000, false),
    RIGHT_5(5, 1_500_000, false),
    BONUS_5(5, 30_000_000, true),
    RIGHT_6(6, 2_000_000_000, false);

    private final int correctCount;
    private final int price;
    private final boolean isBonus;
    private
    LottoResultOutput(int correctCount, int price, boolean isBonus) {
        this.correctCount = correctCount;
        this.price = price;
        this.isBonus = isBonus;
    }

    public static LottoResultOutput valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(WinCount(countOfMatch))
                .filter(isBonus(matchBonus))
                .findFirst()
                .orElseThrow();
    }

    private static Predicate<LottoResultOutput> isBonus(boolean matchBonus) {
        return rank -> !rank.isBonus || rank.isBonus == matchBonus;
    }

    private static Predicate<LottoResultOutput> WinCount(int countOfMatch) {
        return rank -> rank.correctCount == countOfMatch;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrice() {
        return price;
    }
}
