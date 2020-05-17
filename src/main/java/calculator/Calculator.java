package calculator;


public class Calculator {

    private TokenParser tokenParser;

    public Calculator(TokenParser tokenParser) {
        this.tokenParser = tokenParser;
    }

    public Calculator() {
        this(new StringTokenParser());
    }

    public long calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        TokenNumbers tokenNumbers = tokenParser.parseTokenNumbers(input);
        return tokenNumbers.sum();
    }

}
