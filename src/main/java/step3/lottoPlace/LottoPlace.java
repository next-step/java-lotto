package step3.lottoPlace;

import java.util.Arrays;

public enum LottoPlace {
    FIRST(2_000_000_000, 6),
    SECOND(1_500_000, 5),
    THIRD(50_000, 4),
    FORTH(5_000, 3),
    NONE(0, 0);

    private final int price;
    private final int correctNum;

    LottoPlace(int price, int correctNum) {
        this.price = price;
        this.correctNum = correctNum;
    }

    public static LottoPlace findPlaceByCorrectNum(int correctNum) {
        return Arrays.stream(values()).filter(i -> i.correctNum == correctNum).findFirst().orElse(LottoPlace.NONE);
    }

    public int getPrice() {
        return price;
    }

    public int getCorrectNum() {
        return correctNum;
    }
}
