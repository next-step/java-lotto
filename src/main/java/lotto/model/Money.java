package lotto.model;

import java.util.Objects;

import static lotto.util.Const.LOTTERY_PRICE;

public class Money {
    private int value;
    private int investedMoney;

    public Money(int value) {
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

    public void pay(int amount) {
        this.value -= LOTTERY_PRICE * amount;
    }

    public double profitRate(int earnedMoney) {
        return earnedMoney / (double) this.investedMoney;
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                ", investedMoney=" + investedMoney +
                '}';
    }

    public boolean hasEqualValue(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value && investedMoney == money.investedMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, investedMoney);
    }


}
