package stringcalculator;

import java.security.InvalidParameterException;
import java.util.Objects;

public class Operator {

    public static final Operation ADDITION = ((a, b) -> new Number(a.value() + b.value()));
    public static final Operation SUBTRACTION = ((a, b) -> new Number(a.value() - b.value()));
    public static final Operation MULTIPLICATION = ((a, b) -> new Number(a.value() * b.value()));
    public static final Operation DIVISION = ((a, b) -> new Number(a.value() / b.value()));
    public static final String ADDITION_OPERATOR = "+";
    public static final String SUBTRACTION_OPERATOR = "-";
    public static final String MULTIPLICATION_OPERATOR = "*";
    public static final String DIVISION_OPERATOR = "/";

    private Operation operation;

    public Operator(String operation) {
        this.operation = operation(validate(operation));
    }

    private Operation operation(String operation) {
        if (isAddition(operation)) {
            return ADDITION;
        }
        if (isSubtraction(operation)) {
            return SUBTRACTION;
        }
        if (isMultiplication(operation)) {
            return MULTIPLICATION;
        }
        if (isDivision(operation)) {
            return DIVISION;
        }
        throw new InvalidParameterException("사용이 불가능한 연산자 입니다.");
    }

    private boolean isDivision(String operation) {
        return DIVISION_OPERATOR.equals(operation);
    }

    private boolean isMultiplication(String operation) {
        return MULTIPLICATION_OPERATOR.equals(operation);
    }

    private boolean isSubtraction(String operation) {
        return SUBTRACTION_OPERATOR.equals(operation);
    }

    private boolean isAddition(String operation) {
        return ADDITION_OPERATOR.equals(operation);
    }

    private String validate(String operation) {
        if (isEmpty(operation)) {
            throw new InvalidParameterException("연산자는 빈 값일 수 없습니다.");
        }
        return operation;
    }

    private boolean isEmpty(String operation) {
        return operation == null || operation.isBlank();
    }

    public Operation operation() {
        return operation;
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
