package calculator.domain;

import calculator.util.StringUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Calculator {
    private static final String BLANK = " ";
    private static final String ERROR_NULL_OR_EMPTY_MESSAGE = "NULL 또는 공백은 입력할 수 없습니다.";
    private static final String ERROR_FIRST_NOT_NUMBER_MESSAGE = "코드의 시작이 숫자가 아닙니다.";
    private final Queue<String> codes;

    private Calculator(String code) {
        if (StringUtil.isNullOrEmpty(code)) {
            throw new IllegalArgumentException(ERROR_NULL_OR_EMPTY_MESSAGE);
        }
        this.codes = new LinkedList<>(Arrays.asList(code.split(BLANK)));
    }

    public static Calculator from(String str) {
        return new Calculator(str);
    }

    public double execute() {
        if (!StringUtil.isNumeric(codes.peek())) {
            throw new IllegalArgumentException(ERROR_FIRST_NOT_NUMBER_MESSAGE);
        }
        double result = Double.parseDouble(Objects.requireNonNull(codes.poll()));
        while (!codes.isEmpty()) {
            String opCode = codes.poll();
            double number = Double.parseDouble(Objects.requireNonNull(codes.poll()));
            result = Operator.execute(opCode, result, number);
        }
        return result;
    }

}
