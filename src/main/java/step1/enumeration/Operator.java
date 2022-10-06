package step1.enumeration;

import step1.exception.InvalidInputException;
import step1.model.NumberCalculation;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiConsumer;

public enum Operator {
    PLUS("+", NumberCalculation::sum),
    MINUS("-", NumberCalculation::subtract),
    DIVIDE("/", NumberCalculation::divided),
    MULTIPLY("*", NumberCalculation::multiply);

    private String operator;
    private BiConsumer<NumberCalculation, Integer> calculator;

    Operator(String operator, BiConsumer<NumberCalculation, Integer> calculator) {
        this.operator = operator;
        this.calculator = calculator;
    }

    public static Operator findByOperator(String operator) {
        return Arrays.stream(values())
                .filter(op -> Objects.equals(op.operator, operator))
                .findFirst()
                .orElseThrow(() -> new InvalidInputException("[입력 오류] 유효하지 않는 사칙연산 기호가 입력 되었습니다."));
    }

    public void calculate(NumberCalculation first, int second) {
        this.calculator.accept(first, second);
    }
}
