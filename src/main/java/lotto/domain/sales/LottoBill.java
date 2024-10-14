package lotto.domain.sales;

import lotto.constant.ErrorMessage;

public class LottoBill {

    private static final int LOTTO_UNIT_PRICE = 1000;
    private static final int NO_MONEY = 0;

    private final int salesAmount;
    private final int manualCount;

    public LottoBill(int salesAmount) {
        this(salesAmount, 0);
    }

    public LottoBill(int salesAmount, int manualCount) {
        validateSalesAmount(salesAmount);
        validateManualCount(salesAmount, manualCount);
        this.salesAmount = salesAmount;
        this.manualCount = manualCount;
    }

    private static void validateSalesAmount(int salesAmount) {
        if (salesAmount == NO_MONEY || salesAmount % LOTTO_UNIT_PRICE != NO_MONEY) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_PRICE.getMessage());
        }
    }

    private static void validateManualCount(int salesAmount, int manualCount) {
        if (manualCount < 0 || (salesAmount / LOTTO_UNIT_PRICE) < manualCount) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MANUAL_COUNT.getMessage());
        }
    }

    public int quickPick() {
        return (salesAmount / LOTTO_UNIT_PRICE) - manualCount;
    }

    public int manualCount() {
        return manualCount;
    }

    public int salesAmount() {
        return salesAmount;
    }
}
