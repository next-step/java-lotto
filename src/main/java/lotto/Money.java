package lotto;

import static lotto.Const.LOTTERY_PRICE;

public class Money {
    private int value;

    Money(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Money should be more than 0.");
        }
        this.value = value;
    }

    boolean enough() {
        return this.value >= LOTTERY_PRICE;
    }

    void pay() {
        this.value -= LOTTERY_PRICE;
    }

    public double getEarningRate(int earnedMoney) {
        return earnedMoney / (double) this.value;
    }

    public String didEarn(int earnedMoney) {
        if (getEarningRate(earnedMoney) >= 1) {
            return "📈Earned!";
        };
        return "📉Lost..";
    }
}
