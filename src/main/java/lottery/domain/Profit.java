package lottery.domain;

import java.util.Objects;

public class Profit {

    public static final int MINIMUM_JACKPOT = 1;

    private final double profit;

    public Profit(Money money, int jackpot) {
        validateJackpot(jackpot);

        this.profit = money.divide(jackpot);
    }

    private void validateJackpot(int jackpot) {
        if (jackpot < MINIMUM_JACKPOT) {
            throw new IllegalArgumentException("수익은 1보다 작을 수 없습니다. : " + jackpot);
        }
    }

    public Profit(double profit) {
        this.profit = profit;
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
