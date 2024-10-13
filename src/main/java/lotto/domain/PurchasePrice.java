package lotto.domain;

public class PurchasePrice {
    private static final int PRICE_UNIT = 1000;
    private static final String INCORRECT_UNIT_ERROR = "로또 구입금액은 " + PRICE_UNIT + "원 단위여야 합니다.";
    private static final String INCORRECT_VALUE_ERROR = "로또 구입금액의 최소금액은 " + PRICE_UNIT + "원 입니다.";
    private final int money;

    public PurchasePrice(final int money) {
        validateUnit(money);
        validateValue(money);
        this.money = money;
    }

    private void validateUnit(final int money) {
        if (money % PRICE_UNIT != 0) {
            throw new IllegalArgumentException(INCORRECT_UNIT_ERROR);
        }
    }

    private void validateValue(final int money) {
        if (money < PRICE_UNIT) {
            throw new IllegalArgumentException(INCORRECT_VALUE_ERROR);
        }
    }

    public int calculatePurchaseCount() {
        return money / PRICE_UNIT;
    }

    public int getMoney() {
        return money;
    }
}
