package lotto.domain;

public class LottoBill {

    private static final int LOTTO_UNIT_PRICE = 1000;

    private final int salesAmount;

    public LottoBill(int salesAmount) {
        validateSalesAmount(salesAmount);
        this.salesAmount = salesAmount;
    }

    private static void validateSalesAmount(int salesAmount) {
        if (salesAmount == 0 || salesAmount % 1000 != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1,000원 단위로 입력하셔야 합니다.");
        }
    }

    public int quantity() {
        return salesAmount / LOTTO_UNIT_PRICE;
    }
}
