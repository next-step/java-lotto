package lotto;

import java.util.Objects;

import static lotto.Const.LOTTERY_PRICE;

public class Money {
    private int value;
    private int investedMoney;

    Money(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Money should be more than 0.");
        }
        this.value = value;
        this.investedMoney = value;
    }

    public String toPayload() {
        return "₩" + this.value;
    }

    boolean enough() {
        return this.value >= LOTTERY_PRICE;
    }

    void pay() {
        this.value -= LOTTERY_PRICE;
    }

    public double profitRate(int earnedMoney) {
        return earnedMoney / (double) this.investedMoney;
    }

    @Override
    public String toString() {
        return "Money{" + "value=" + value + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public static int multiply(Money money, int wonNumbers) {
        return money.value * wonNumbers;
    }

    public int calc(Integer win) {
        return this.value * win;
    }

}
