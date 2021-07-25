package lotto.exception;

public class IllegalMoneyNumberException extends RuntimeException {
    public IllegalMoneyNumberException(long number) {
        super("구입 금액은 0보다 크고 1000으로 나누어 떨어지는 금액 이여야 합니다. ===" + number);
    }
}
