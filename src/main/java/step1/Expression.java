package step1;

public class Expression {
    private static final String BLANK = " ";
    private final String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public char[] getCharArray() {
        return eliminateBlank().toCharArray();
    }

    private String eliminateBlank() {
        return expression.replaceAll(BLANK, "");
    }
}
