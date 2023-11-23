package calculator;

import calculator.operator.Operator;
import java.util.List;

public class OperationRepository {

    public static final String INPUT_OPERATOR_EXCEPTION = "입력하신 연산자가 사칙 연산 연산자가 아닙니다.";

    private final List<Operator> operators;

    public OperationRepository(List<Operator> operators) {
        this.operators = operators;
    }

    public Operator findOperation(String textOperator) {
        return operators.stream()
                .filter(operator -> operator.match(textOperator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INPUT_OPERATOR_EXCEPTION));
    }
}
