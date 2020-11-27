package humbledude.lotto.domain;

public class Budget {

    private final long budget;
    private long totalSpending = 0;

    public Budget(long budget) {
        this.budget = budget;
    }

    public boolean isWithinBudget(long spending) {
        return totalSpending + spending <= budget;
    }

    public void addSpending(long spending) {
        if (!isWithinBudget(spending)) {
            throw new IllegalArgumentException("예산 초과!!");
        }
        this.totalSpending += spending;
    }

    public long getTotalSpending() {
        return totalSpending;
    }

    public long getRemain() {
        return budget - totalSpending;
    }
}
