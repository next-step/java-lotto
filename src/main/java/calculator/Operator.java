package calculator;

public class Operator {
    private String value;

    public Operator(String value) {

        if (OperatorEnum.getEnumByValue(value) == null) {
            throw new IllegalArgumentException("유효한 연산자가 아닙니다.");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
