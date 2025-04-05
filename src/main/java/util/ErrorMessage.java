package util;

import calculator.Operator;

public class ErrorMessage {

    public static final String INVALID_INPUT = "입력 값이 null 일수 없습니다.";
    public static final String INVALID_STRING = "입력 값에는 문자가 들어갈 수 없습니다.";
    public static final String INVALID_OPERATOR = "유효하지 않은 연산자입니다.(+, -, *, / 가능)";
    public static final String INVALID_NUMBER = "0으로 나눌 수 없습니다.";
    public static final String INVALID_FORMAT = "올바른 연산식이 아닙니다. (" + Operator.supportSymbols() + "가능)";

    private ErrorMessage() {
    }
}
