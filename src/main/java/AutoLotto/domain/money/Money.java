package AutoLotto.domain.money;

import java.util.Objects;

import static AutoLotto.utils.CheckDivideBy.divideToDecimal;
import static AutoLotto.utils.CheckMoney.isNullOrBlank;

public class UserMoney {

    private final int budget;

    public UserMoney(int budget) {
        this.budget = budget;
    }

    public int getBudget() {
        return budget;
    }

    public int makeBudget() {
        String value = Integer.toString(budget);
        if(isNullOrBlank(value)) {
            return 0;
        }
        return Integer.parseInt(value);
    }

    public boolean isPlusProfitBy(int buzzMoney) {
        Double profitRate = makeProfitRateBy(buzzMoney);
        return profitRate >= 1;
    }

    private Double makeProfitRateBy(int buzzMoney) {
        String left = Integer.toString(buzzMoney);
        String right = Integer.toString(budget);
        Double profitRate = divideToDecimal(left, right);
        return profitRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        UserMoney userMoney1 = (UserMoney) o;
        return budget == userMoney1.budget;
    }

    @Override
    public int hashCode() {
        return Objects.hash(budget);
    }
}
