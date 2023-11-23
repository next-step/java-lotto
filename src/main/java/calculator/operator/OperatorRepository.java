package calculator.operator;

import java.util.List;

public class OperatorRepository {

    public static final String INPUT_OPERATOR_EXCEPTION = "입력하신 연산자가 사칙 연산 연산자가 아닙니다.";

    private final List<OperatorStrategy> operators;

    public OperatorRepository(List<OperatorStrategy> operators) {
        this.operators = operators;
    }

    public OperatorStrategy findOperator(String textOperator) {
        return operators.stream()
                .filter(operatorStrategy -> operatorStrategy.matchable(textOperator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INPUT_OPERATOR_EXCEPTION));
    }
}
