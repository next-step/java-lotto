package step1;

public enum Symbol {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public static Symbol fromString(String text) {
        for (Symbol operation : Symbol.values()) {
            if (isEqualsTo(text, operation)) {
                return operation;
            }
        }
        throw new IllegalStateException("알 수 없는 연산자입니다.");
    }

    private static boolean isEqualsTo(String text, Symbol operation) {
        return operation.symbol.equals(text);
    }
}
