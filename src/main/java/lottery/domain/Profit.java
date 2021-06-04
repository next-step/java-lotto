package lottery.domain;

import java.util.Objects;

public class Profit {

    public static final int DEFAULT_PROFIT = 0;

    private final double profit;

    public Profit(Money money, int jackpot) {
        this.profit = calculate(money, jackpot);
    }

    public Profit(double profit) {
        this.profit = profit;
    }

    private double calculate(Money inputMoney, int jackpot) {
        return (double) jackpot / inputMoney.toDouble();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profit profit1 = (Profit) o;
        return profit == profit1.profit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(profit);
    }

    @Override
    public String toString() {
        return String.valueOf(profit);
    }
}
