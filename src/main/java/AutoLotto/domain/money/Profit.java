package AutoLotto.domain.money;

import AutoLotto.utils.CheckDivideBy;

import java.util.Objects;


public class Profit {

    private final int profit;

    public Profit (int profit) {
        this.profit = profit;
    }

    public int getProfit() {
        return profit;
    }

    public static boolean isPlusProfitBy(int budget, int buzzMoney) {
        String left = Integer.toString(buzzMoney);
        String right = Integer.toString(budget);
        Double profitRate = CheckDivideBy.divideToDecimal(left, right);
        return profitRate >= 1;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Profit profit1 = (Profit) o;
        return profit == profit1.profit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(profit);
    }
}
