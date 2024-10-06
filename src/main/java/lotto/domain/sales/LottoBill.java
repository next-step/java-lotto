package lotto.domain.sales;

import lotto.constant.ErrorMessage;

public class LottoBill {

    private static final int LOTTO_UNIT_PRICE = 1000;

    private final int salesAmount;

    public LottoBill(int salesAmount) {
        validateSalesAmount(salesAmount);
        this.salesAmount = salesAmount;
    }

    private static void validateSalesAmount(int salesAmount) {
        if (salesAmount == 0 || salesAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_PRICE.getMessage());
        }
    }

    public int quantity() {
        return salesAmount / LOTTO_UNIT_PRICE;
    }

    public int salesAmount() {
        return salesAmount;
    }
}
