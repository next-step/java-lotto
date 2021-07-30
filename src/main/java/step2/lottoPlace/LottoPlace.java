package step2.lottoPlace;

import java.util.Arrays;

public enum LottoPlace {
    FIRST(2_000_000_000, 6),
    SECOND(1_500_000,  7),
    THIRD(50_000,  8),
    FORTH(5_000,  9),
    NONE(0,  0)
    ;
    private final int price;
    private final int distinctNum;

    LottoPlace(int price, int distinctNum) {
        this.price = price;
        this.distinctNum = distinctNum;
    }

    public static LottoPlace findPlaceByDistinctNum(int distinctNum) {
        return Arrays.stream(values())
            .filter(i -> i.distinctNum == distinctNum)
            .findFirst()
            .orElse(LottoPlace.NONE);
    }

    public int getPrice() {
        return price;
    }
}
