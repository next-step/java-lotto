package lotto.exception;

public class NumberInputRuleException extends RuntimeException {
    private static final String MESSAGE = "번호 입력시 구분자는 ', '를 이용하여 입력하여야 합니다.";

    public NumberInputRuleException() {
        super(MESSAGE);
    }

}
