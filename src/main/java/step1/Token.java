package step1;

public class Token {
    private final String token;

    public Token(String token) {
        this.token = token;
    }

    public boolean isNumber() {
        return token.matches("\\d+");
    }

    public boolean isOperator() {
        return token.matches("[\\+\\-\\*\\/]");
    }

    public boolean isPlusOperator() {
        return token.equals("+");
    }

    public boolean isMinusOperator() {
        return token.equals("-");
    }

    public boolean isMultiplyOperator() {
        return token.equals("*");
    }

    public boolean isDevideOperator() {
        return token.equals("/");
    }

    public int toInt() {
        return Integer.parseInt(token);
    }
}
