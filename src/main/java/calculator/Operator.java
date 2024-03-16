package calculator;

public enum Operator {
    PLUS("+"), MINUS("-"), DIVIDE("/"), SQUARE("*"), NONE("");

    private String value;

    Operator(String value) {
        this.value = value;
    }

    public static Operator findOperationByValue(String value) {
        for(Operator operator : Operator.values()) {
            String operatorValue = operator.value;
            if(operatorValue.equals(value)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("유요하지 않은 연산자: " + value);
    }
}
