package lotto.domain;

public class Money {

    private static final int MIN_PURCHASE_MONEY = 1_000;
    private static final int MAX_PURCHASE_MONEY = 100_000;
    private static final String MONEY_RANGE_EXCEPTION_MESSAGE =
            "로또는 " + MIN_PURCHASE_MONEY + "원 이상 " + MAX_PURCHASE_MONEY + "원 이하만 구매할 수 있습니다";
    private static final String NUMBER_PATTERN = "\\d+";
    private static final String NOT_NUMERIC_EXCEPTION_MESSAGE = "숫자만 입력할 수 있습니다.";
    private static final String CAN_NOT_BUY_EXCEPTION_MESSAGE = "주어진 돈으로 해당 개수 만큼 로또를 구매할 수 없습니다.";

    private final int value;

    Money(final int value) {
        this.value = value;
    }

    public Money(final String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(final String value) {
        validateNumericPattern(value);
        validateRangeOfMoney(Integer.parseInt(value));
    }

    private void validateNumericPattern(final String value) {
        if (!value.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(NOT_NUMERIC_EXCEPTION_MESSAGE);
        }
    }

    private void validateRangeOfMoney(final int money) {
        if (money < MIN_PURCHASE_MONEY || MAX_PURCHASE_MONEY < money) {
            throw new IllegalArgumentException(MONEY_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public Money receiveAfterPurchaseLotto(LottoBuyCount lottoBuyCount) {
        validateCanPurchaseLottoWantedCount(lottoBuyCount);
        return new Money(this.value - Lotto.calculatePurchaseMoney(lottoBuyCount).getValue());
    }

    public void validateCanPurchaseLottoWantedCount(LottoBuyCount lottoBuyCount) {
        if (this.value < Lotto.calculatePurchaseMoney(lottoBuyCount).getValue()) {
            throw new IllegalArgumentException(CAN_NOT_BUY_EXCEPTION_MESSAGE);
        }
    }

    public int getValue() {
        return this.value;
    }
}
