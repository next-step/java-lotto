package lotto;

import java.util.Map;
import java.util.Objects;

import static lotto.Const.LOTTERY_PRICE;

public class Money {
    private int value;



    Money(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Money should be more than 0.");
        }
        this.value = value;
    }

    public static String toPayload(Map<Integer, Integer> matches) {
        StringBuilder payload = new StringBuilder("");
        for (int key : matches.keySet()) {
            payload.append(key + " matches (₩" + Reward.of(key).money.value + "): " + matches.get(key) + "\n");
        }
        return payload.toString();
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

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                '}';
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
}
