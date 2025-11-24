package calculate.domain;

import java.util.Calendar;

public class Executor {

    private Expression expression;

    public Executor(String input) {
        this(new Expression(input));
    }

    public Executor(Expression expression) {
        this.expression = expression;
    }

    public int calculate() {
        String[] inputList = expression.split();

        int result = Integer.parseInt(inputList[0]);

        for (int i = 1; i < inputList.length; i += 2) {
            String operator = inputList[i];
            int value = Integer.parseInt(inputList[i+1]);
            result = Calculator.fromSymbol(operator).calculate(result, value);
        }

        return result;
    }

}
