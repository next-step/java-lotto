package lotto;

import java.util.Arrays;
import java.util.Objects;


public enum WinningPrice {
    FIRST(6, 2000000000,0),
    SECOND(5, 3000000,1),
    THIRD(5, 1500000,0),
    FOUR(4, 50000,0),
    FIVE(3, 5000,0);

    private final int equalCount;
    private final int price;
    private int bonusEqualCount = 0;

    WinningPrice(int equalCount, int price) {
        this.equalCount = equalCount;
        this.price = price;
    }

    WinningPrice(int equalCount, int price, int bonusEqualCount){
        this(equalCount,price);
        this.bonusEqualCount = bonusEqualCount;
    }

    public int getPrice() {
        return price;
    }

    public int getEqualCount() {
        return equalCount;
    }

    public static WinningPrice of(int equalCount) {
        return Arrays.stream(values()).filter(
                s -> Objects.equals(s.equalCount, equalCount)
        ).findFirst().get();
    }

    public static WinningPrice of(int equalCount,int bonusEqualCount) {
        return Arrays.stream(values()).filter(
                s -> Objects.equals(s.equalCount, equalCount) && Objects.equals(s.bonusEqualCount, bonusEqualCount)
        ).findFirst().orElse(null);
    }

    public static int getFirstEqualCount() {
        return FIRST.equalCount;
    }

    public static int getLastEqualCount() {
        return FOUR.equalCount;
    }


}
