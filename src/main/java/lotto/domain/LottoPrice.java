package lotto.domain;

import java.util.Arrays;

public enum LottoPrice {
    MISS(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int count;
    private final int price;
    private final boolean bonusResult;

    LottoPrice(int count, int price, boolean bonusResult) {
        this.count = count;
        this.price = price;
        this.bonusResult = bonusResult;
    }

    public boolean isBonusResult() {
        return bonusResult;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public static LottoPrice valueOf(int match, boolean matchBonus) {
        return Arrays.stream(values())
            .filter(item -> item.count == match)
            .filter(item -> match != 5 || item.bonusResult == matchBonus)
            .findAny().orElse(MISS);
    }


}
