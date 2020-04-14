package lotto.domain;

public class ManualCount {
    public static final String OVER_BUDGET = "구입 금액 초과";

    private final Money money;
    private final int manualCounts;

    public ManualCount(Money money, int manualCounts) {
        this.money = money;
        this.manualCounts = validateCounts(money, manualCounts);
    }

    private int validateCounts(Money money, int manualCounts) {
        if (manualCounts > money.getLottoCount()) {
            throw new IllegalArgumentException(OVER_BUDGET);
        }
        return manualCounts;
    }

    public int getManualCounts() {
        return manualCounts;
    }
}
