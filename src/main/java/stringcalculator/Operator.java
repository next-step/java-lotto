package stringcalculator;

import static stringcalculator.Operator.OperationMap.isUsableOperator;
import static stringcalculator.Operator.OperationMap.operation;

import java.security.InvalidParameterException;
import java.util.Map;
import java.util.Objects;

public class Operator {

    public static class OperationMap {

        public static final Operation ADDITION = ((a, b) -> new Number(a.value() + b.value()));
        public static final Operation SUBTRACTION = ((a, b) -> new Number(a.value() - b.value()));
        public static final Operation MULTIPLICATION = ((a, b) -> new Number(a.value() * b.value()));
        public static final Operation DIVISION = ((a, b) -> new Number(validDivision(a, b)));
        public static final String ADDITION_OPERATOR = "+";
        public static final String SUBTRACTION_OPERATOR = "-";
        public static final String MULTIPLICATION_OPERATOR = "*";
        public static final String DIVISION_OPERATOR = "/";
        public static final Map<String, Operation> OPERATION_MAP = Map.of(
            ADDITION_OPERATOR, ADDITION,
            SUBTRACTION_OPERATOR, SUBTRACTION,
            MULTIPLICATION_OPERATOR, MULTIPLICATION,
            DIVISION_OPERATOR, DIVISION
        );

        public static boolean isUsableOperator(String operator) {
            return !OPERATION_MAP.containsKey(operator);
        }

        public static Operation operation(String operator) {
            return OPERATION_MAP.get(operator);
        }

        private static int validDivision(Number a, Number b) {
            if (isInDivisible(a, b)) {
                throw new InvalidParameterException("나누어 떨어지지 않는 수로는 나눌수 없습니다. : " + a.value() + " / " + b.value());
            }
            return a.value() / b.value();
        }

        private static boolean isInDivisible(Number a, Number b) {
            return a.value() % b.value() != 0;
        }

    }

    private Operation operation;

    public Operator(String operation) {
        this.operation = validOperation(NonEmptyString(operation));
    }

    private String NonEmptyString(String operation) {
        if (isEmpty(operation)) {
            throw new InvalidParameterException("연산자는 빈 값일 수 없습니다.");
        }
        return operation;
    }

    private boolean isEmpty(String operation) {
        return operation == null || operation.isBlank();
    }

    private Operation validOperation(String operator) {
        if (isUsableOperator(operator)) {
            throw new InvalidParameterException("사용이 불가능한 연산자 입니다.");
        }
        return operation(operator);
    }

    public Number calculation(Number a, Number b) {
        return operation.calculation(a, b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operator operator1 = (Operator) o;
        return Objects.equals(operation, operator1.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation);
    }

}
