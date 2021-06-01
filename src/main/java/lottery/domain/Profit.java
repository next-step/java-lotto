package lottery.domain;

import java.util.Objects;

public class Profit {

    public static final int DEFAULT_PROFIT = 0;

    private int profit;

    public Profit() {
        this.profit = DEFAULT_PROFIT;
    }

    public Profit(int profit) {
        this.profit = profit;
    }

    public void add(int profit) {
        this.profit += profit;
    }

    public int profit() {
        return profit;
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
}
