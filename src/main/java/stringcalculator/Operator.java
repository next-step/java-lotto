package stringcalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", (firstOperand, secondOperand) -> firstOperand + secondOperand),
    SUBTRACTION("-", (firstOperand, secondOperand) -> firstOperand - secondOperand),
    MULTIPLICATION("*", (firstOperand, secondOperand) -> firstOperand * secondOperand),
    DIVISION("/", (firstOperand, secondOperand) -> firstOperand / secondOperand);

    private String operatorCode;
    private BiFunction<Integer, Integer, Integer> calculation;

    Operator(String operatorCode, BiFunction<Integer, Integer, Integer> calculation) {
        this.operatorCode = operatorCode;
        this.calculation = calculation;
    }

    public static Operator from(String operatorCode) {
        return Arrays.stream(values())
                .filter(operator -> operator.operatorCode.equals(operatorCode))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("연산자는 +, -, *, / 기호만 입력 가능합니다."));
    }

    public static String calculate(String operatorCode, String firstOperand, String secondOperand) {
        return toString(from(operatorCode).calculation.apply(toInt(firstOperand), toInt(secondOperand)));
    }

    private static int toInt(String operand) {
        return Integer.parseInt(operand);
    }

    private static String toString(int operand) {
        return String.valueOf(operand);
    }
}
