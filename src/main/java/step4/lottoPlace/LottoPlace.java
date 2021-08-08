package step4.lottoPlace;

import java.util.Arrays;

public enum LottoPlace {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FORTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    NONE(0, 0, false);

    private final int price;
    private final int correctNum;
    private final boolean isBonusNumCorrect;

    LottoPlace(int price, int correctNum, boolean isBonusNumCorrect) {
        this.price = price;
        this.correctNum = correctNum;
        this.isBonusNumCorrect = isBonusNumCorrect;
    }

    public static LottoPlace findPlaceByCorrectNum(int correctNum, boolean isBonusNumCorrect) {
        return Arrays.stream(values())
            .filter(i -> i.correctNum == correctNum && (isBonusNumCorrect & i.isBonusNumCorrect) == i.isBonusNumCorrect)
            .findFirst()
            .orElse(LottoPlace.NONE);
    }

    public int getPrice() {
        return price;
    }

    public int getCorrectNum() {
        return correctNum;
    }
}
