package calculator;

public class Calculator {

    private final Parser parser;

    public Calculator(Parser parser) {
        this.parser = parser;
    }

    public int sum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }
        
        Sequence sequence = parser.generateSequence(expression);

        return sequence.sum();
    }

}
