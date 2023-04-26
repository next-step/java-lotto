import java.security.InvalidParameterException;

public enum Operation {
    PLUS("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public static Operation toOperation(String operation) {
        for (Operation value : values()) {
            if (value.operation.equals(operation)) {
                return value;
            }
        }
        throw new InvalidParameterException("유효한 연산자가 아닙니다.");
    }


}
