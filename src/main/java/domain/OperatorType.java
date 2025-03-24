package domain;

public enum OperatorType {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String value;

    OperatorType(String value) {
        this.value = value;
    }

    public static OperatorType findOperatorByString(String value) {
        OperatorType operatorType = null;
        for (OperatorType candidateOperatorType : OperatorType.values()) {
            operatorType = matchValue(value, operatorType, candidateOperatorType);
        }

        if (operatorType == null) {
            throw new IllegalArgumentException("Invalid operator");
        }

        return operatorType;
    }

    private static OperatorType matchValue(String value, OperatorType currentOperatorType, OperatorType operatorType) {
        if (currentOperatorType != null) {
            return currentOperatorType;
        }

        if (operatorType.value.equals(value)) {
            return operatorType;
        }
        return null;
    }
}
