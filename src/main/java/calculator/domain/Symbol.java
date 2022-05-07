package calculator.domain;

public enum Symbol {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String sign;

    Symbol(String sign) {
        this.sign = sign;
    }

    public static Symbol classifySymbol(String sign) {
        switch (sign) {
            case "+" : return Symbol.PLUS;
            case "-" : return Symbol.MINUS;
            case "*" : return Symbol.MULTIPLY;
            case "/" : return Symbol.DIVIDE;
            default:
                throw new IllegalArgumentException("올바르지 않은 연산자 입니다.");
        }
    }
}
