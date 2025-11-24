package calculate.domain;

public class Executor {

    private Expression expression;

    public Executor(String input) {
        this(new Expression(input));
    }

    public Executor(Expression expression) {
        this.expression = expression;
    }

    public int calculate() {
        String[] inputList = splitExpression();
        int result = calculateFirstNumber(inputList);
        result = calculateOtherNumber(inputList, result);
        return result;
    }

    private String[] splitExpression() {
        return expression.split();
    }

    private int calculateOtherNumber(String[] inputList, int result) {
        for (int i = 1; i < inputList.length; i += 2) {
            String operator = inputList[i];
            int value = Integer.parseInt(inputList[i+1]);
            result = Calculator.fromSymbol(operator).calculate(result, value);
        }
        return result;
    }

    private int calculateFirstNumber(String[] inputList) {
        return Integer.parseInt(inputList[0]);
    }

}
