package AutoLotto.domain.money;

import AutoLotto.utils.CheckMoney;

import java.util.Objects;

public class Budget {

    private final int budget;

    public Budget(int budget) {
        this.budget = budget;
    }

    public int getBudget() {
        return budget;
    }

    public static int makeBudget(String value) {
        if(CheckMoney.isNullOrBlank(value)) {
            return 0;
        }
        return Integer.parseInt(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Budget budget1 = (Budget) o;
        return budget == budget1.budget;
    }

    @Override
    public int hashCode() {
        return Objects.hash(budget);
    }
}
