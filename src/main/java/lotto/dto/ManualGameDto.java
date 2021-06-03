package lotto.dto;

import lotto.store.Budget;
import lotto.store.ManualCount;

public class ManualGameDto {

    private final Budget budget;
    private final ManualCount manualCount;

    public ManualGameDto(Budget budget, ManualCount manualCount) {
        this.budget = budget;
        this.manualCount = manualCount;
    }

    public void isValidManualCountBy(int price) {
        int count = budget.get() / price;
        if (count < manualCount.get()) {
            throw new IllegalArgumentException("수동 구매 개수는 총 구매 개수를 초과할 수 없습니다");
        }
    }

    public Budget getBudget() {
        return budget;
    }

    public int getManualCount() {
        return manualCount.get();
    }
}
