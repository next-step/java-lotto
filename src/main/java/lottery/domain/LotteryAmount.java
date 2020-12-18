package lottery.domain;

import java.util.Objects;

public class LotteryAmount {
    public static final int LOTTERY_PRICE = 1000;

    private final int amount;

    public LotteryAmount(int price) {
        if (price < LOTTERY_PRICE) {
            this.amount = 0;
            throw new IllegalArgumentException("로또 1장의 가격은 " + LOTTERY_PRICE + "입니다.");
        }
        this.amount = price / LOTTERY_PRICE;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryAmount that = (LotteryAmount) o;
        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
