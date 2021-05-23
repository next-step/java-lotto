package lotto.domain.wrapper;

public class LottoPurchase {

    private final LottoPurchaseBudget budget;
    private final LottoPurchaseManualCount manualCount;

    public LottoPurchase(int budget) {
        this(budget, 0);
    }

    public LottoPurchase(int budgetMoney, int manualCount) {
        this.budget = new LottoPurchaseBudget(budgetMoney);

        if (budget.isUnderManualBudgetOf(manualCount) || manualCount < 0) {
            throw new IllegalArgumentException("로또 수동구매 가능 개수가 아닙니다.");
        }

        this.manualCount = new LottoPurchaseManualCount(manualCount);
    }

    public int countOfAvailableAutoLotto() {
        return budget.countOfAvailableLotto() - manualCount.count();
    }

    public int budget() {
        return budget.budget();
    }

    public int manualCount() {
        return manualCount.count();
    }
}
