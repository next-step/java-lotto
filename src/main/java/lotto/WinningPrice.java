package lotto;

import java.util.Arrays;
import java.util.Objects;


public enum WinningPrice {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOUR(3, 5000);

    private final int equalCount;
    private final int price;

    WinningPrice(int equalCount, int price) {
        this.equalCount = equalCount;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static WinningPrice of(int equalCount) {
        return Arrays.stream(values()).filter(
                s -> Objects.equals(s.equalCount, equalCount)
        ).findFirst().get();
    }

    public static int getFirstEqualCount() {
        return FIRST.equalCount;
    }

    public static int getLastEqualCount() {
        return FOUR.equalCount;
    }


}
