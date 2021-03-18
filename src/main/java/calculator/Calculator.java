package calculator;

public class Calculator {

    public int sum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }
        
        Sequence sequence = Parser.generateSequence(expression);

        return sequence.sum();
    }

}
