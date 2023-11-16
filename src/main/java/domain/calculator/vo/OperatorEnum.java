package domain.calculator.vo;

public enum OperatorEnum {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

    private final String symbol;

    OperatorEnum(String symbol) {
        this.symbol = symbol;
    }

    public static OperatorEnum of(String symbol) {
        for (OperatorEnum operatorEnum : OperatorEnum.values()) {
            if (operatorEnum.symbol.equals(symbol)) {
                return operatorEnum;
            }
        }
        throw new IllegalArgumentException("연산자가 존재하지 않습니다.");
    }

    public String getSymbol() {
        return symbol;
    }
}
