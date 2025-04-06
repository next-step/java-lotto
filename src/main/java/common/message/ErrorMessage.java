package common.message;

import calculator.Operator;

public class ErrorMessage {

    public static final String INVALID_INPUT = "입력 값이 null 일수 없습니다.";
    public static final String INVALID_STRING = "입력 값에는 문자가 들어갈 수 없습니다.";
    public static final String INVALID_OPERATOR = "유효하지 않은 연산자입니다.(+, -, *, / 가능)";
    public static final String INVALID_NUMBER = "0으로 나눌 수 없습니다.";
    public static final String INVALID_FORMAT = "올바른 연산식이 아닙니다. (" + Operator.supportSymbols() + "가능)";


    public static final String INVALID_PURCHASE_AMOUNT = "구입 금액은 0보다 커야 합니다.";
    public static final String INVALID_LOTTO_SIZE = "로또 번호는 %d 개 여야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBER = "로또 번호는 중복될 수 없습니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE = "로또 번호는 %d부터 %d사이여야 합니다.";

    private ErrorMessage() {
    }
}
