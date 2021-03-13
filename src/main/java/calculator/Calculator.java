package calculator;

public class Calculator {

    private final Parser parser;

    public Calculator(Parser parser) {
        this.parser = parser;
    }

    public int sum(String expression) {
        return parser.makeSequence(expression)
                     .stream()
                     .mapToInt(Integer::parseInt)
                     .sum();
    }

}
