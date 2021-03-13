package calculator;

public class Calculator {

    private final Parser parser;

    public Calculator(Parser parser) {
        this.parser = parser;
    }

    public int sum(String expression) {
        Sequence sequence = parser.generateSequence(expression);

        return sequence.sum();
    }

}
