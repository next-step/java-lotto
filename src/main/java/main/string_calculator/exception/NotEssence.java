package main.string_calculator.exception;

public class NotEssence extends RuntimeException {
    private static final String MESSAGE = "나눗셈의 경우 결과 값이 정수로 떨어지는 값으로 한정합니다.";

    public NotEssence() {
        super(MESSAGE);
    }
}
