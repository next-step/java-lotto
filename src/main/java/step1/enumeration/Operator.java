package step1.enumeration;

import step1.exception.InvalidInputException;
import step1.model.NumberCalculation;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Operator {
    PLUS("+", NumberCalculation::sum),
    MINUS("-", NumberCalculation::subtract),
    DIVIDE("/", NumberCalculation::divided),
    MULTIPLY("*", NumberCalculation::multiply);

    private String operator;
    private BiConsumer<NumberCalculation, Integer> calculator;

    private static Map<String, Operator> operatorMap = Arrays.stream(Operator.values())
            .collect(Collectors.toMap(op -> op.operator, Function.identity()));

    Operator(String operator, BiConsumer<NumberCalculation, Integer> calculator) {
        this.operator = operator;
        this.calculator = calculator;
    }

    public static Operator getOperator(String operator) {
        return Optional.ofNullable(operatorMap.get(operator))
                .orElseThrow(() -> new InvalidInputException("[입력 오류] 유효하지 않는 사칙연산 기호가 입력 되었습니다."));
    }

    public void calculate(NumberCalculation first, String second) {
        this.calculator.accept(first, Integer.parseInt(second));
    }
}
