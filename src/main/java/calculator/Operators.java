package calculator;

public enum Operators {

    PLUS("+"), MINUS("-"), MUL("*"), DIV("/");
    private final String value;

    Operators(String value) {
        this.value = value;
    }

    public boolean isSame(String value) {
        return this.value.equals(value);
    }
}
