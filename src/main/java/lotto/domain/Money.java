package lotto.domain;

public class Money {
    private static final String NOT_NUMBER_COMMENT = "숫자를 입력해 주세요";
    private static final String NOT_AVAILABLE_COMMENT = "1000원 이상, 1000원 단위로 입력해주세요";
    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public Money(String money) {
        this.money = parsingMoney(money);
        if (isNotAvailable()) {
            throw new IllegalArgumentException(NOT_AVAILABLE_COMMENT);
        }
    }

    private int parsingMoney(String money) {
        validateMoney(money);
        if (isNotParsable(money)) {
            throw new IllegalArgumentException(NOT_NUMBER_COMMENT);
        }
        return Integer.parseInt(money);
    }

    private boolean isNotAvailable() {
        return this.money % LOTTO_PRICE != 0 || this.money < 0;
    }

    private void validateMoney(String money) {
        if (money == null || money.trim().isEmpty()) {
            throw new IllegalArgumentException(NOT_NUMBER_COMMENT);
        }
    }

    private boolean isNotParsable(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    public int value() {
        return this.money;
    }

    public int getLottoCount() {
        return this.money / LOTTO_PRICE;
    }
}
