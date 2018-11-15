package lotto.domain;

import lotto.exceptions.ValidationException;

public class LottoCountManager {

    private static final int LOTTO_PRICE = 1000;

    private int budget;
    private int manualCount;

    public LottoCountManager(int budget, int manualCount) {
        this.budget = budget;
        this.manualCount = manualCount;

        if (this.getCountByBudget() < manualCount) {
            throw new ValidationException();
        }
    }

    public int getCountByBudget() {
        return this.budget / LOTTO_PRICE;
    }

    public int getManualCount() {
        return this.manualCount;
    }

    public double getRatio(double totalMoney) {
        return totalMoney / (double) budget;
    }

    public int getAutoLottoCount() {
        return this.getCountByBudget() - this.manualCount;
    }
}
