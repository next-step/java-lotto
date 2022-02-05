package lotto.domain;

public class Money {

    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 숫자가 아닙니다";
    private static final String NOT_PURCHASABLE_EXCEPTION_MESSAGE = "[ERROR] 1000원 이상, 1000원 단위로 입력해주세요";
    private static final int LOTTO_PRICE = 1_000;

    private int money;

    public Money(String money) {
        this.money = parseMoney(money);
        validateMoney();
    }

    public int value() {
        return money;
    }

    private void validateMoney() {
        if (notPurchasable()) {
            throw new IllegalArgumentException(NOT_PURCHASABLE_EXCEPTION_MESSAGE);
        }
    }

    private boolean notPurchasable() {
        return money < LOTTO_PRICE || money % LOTTO_PRICE != 0;
    }

    private int parseMoney(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
