package dto.string_calculator;

public class Operation {
    private final String operation;

    public Operation(String operation) {
        if (!isOperation(operation)) {
            throw new IllegalArgumentException("유효하지 않은 문자열입니다.");
        }
        this.operation = operation;
    }

    private boolean isOperation(String numberAndOperation) {
        return "+".equals(numberAndOperation) || "-".equals(numberAndOperation) || "*".equals(numberAndOperation) || "/".equals(numberAndOperation);
    }

    public String getOperation() {
        return operation;
    }
}
