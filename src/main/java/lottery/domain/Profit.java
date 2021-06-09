package lottery.domain;

import java.util.Objects;

public class Profit {

    private final double profit;

    public Profit(Money money, Money jackpot) {
        validateJackpot(jackpot);

        this.profit = jackpot.divide(money);
    }

    public Profit(double profit) {
        this.profit = profit;
    }

    private void validateJackpot(Money jackpot) {
        if (jackpot.isBiggerThanMinimumJackpot()) {
            throw new IllegalArgumentException("수익은 1보다 작을 수 없습니다. : " + jackpot);
        }
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
