package stringcalculator;

import java.security.InvalidParameterException;
import java.util.Objects;
import java.util.regex.Pattern;

public class Operation {

    public static final Pattern VALID_OPERATIONS = Pattern.compile("^(\\+|-|\\*|\\/)$");

    private String operation;

    public Operation(String operation) {
        validate(operation);
        this.operation = operation;
    }

    private void validate(String operation) {
        if (isEmpty(operation)) {
            throw new InvalidParameterException("연산자는 빈 값일 수 없습니다.");
        }
        if (isInvalid(operation)) {
            throw new InvalidParameterException("사용이 불가능한 연산자 입니다.");
        }
    }

    private boolean isInvalid(String operation) {
        return !VALID_OPERATIONS.matcher(operation).find();
    }

    private boolean isEmpty(String operation) {
        return operation == null || operation.isBlank();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operation operation1 = (Operation) o;
        return Objects.equals(operation, operation1.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation);
    }

}
