package AutoLotto.domain.money;

import java.util.Objects;

import static AutoLotto.utils.CheckDivideBy.divideToDecimal;
import static AutoLotto.utils.CheckMoney.isNullOrBlank;

public class Money {

    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int makeMoney() {
        String value = Integer.toString(money);
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
        String right = Integer.toString(money);
        Double profitRate = divideToDecimal(left, right);
        return profitRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
