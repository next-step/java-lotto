package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    FAIL(0, 0);

    private final int collectNumber;
    private final int price;

    LottoRank(final int collectNumber, final int price) {
        this.collectNumber = collectNumber;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getCollectNumber() {
        return collectNumber;
    }

    public static LottoRank findRank(int collectNumber, boolean matchBonus) {
        if (collectNumber == 5) {
            return checkSecondOrThird(matchBonus);
        }

        return Arrays.stream(values())
            .filter(LottoRank -> LottoRank.matchCount(collectNumber))
            .findFirst()
            .orElse(FAIL);
    }

    private boolean matchCount(int collectNumber) {
        return this.collectNumber == collectNumber;
    }

    private static LottoRank checkSecondOrThird(boolean matchBonus) {
        if (matchBonus) {
            return SECOND;
        }
        return THIRD;
    }


}
