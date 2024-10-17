package stringcalculator;

public class Calculator {
    private MathExpression mathExpression;
    private CurrentCalculationResult currentCalculationResult;

    public Calculator(String mathExpression) {
        this(mathExpression,0);

    }

    public Calculator(String mathExpression, int inputCurrentCalculationResult ) {
        this.mathExpression = new MathExpression(mathExpression);
        this.currentCalculationResult = new CurrentCalculationResult(inputCurrentCalculationResult);
    }

    public void checkMathExpression() {
        mathExpression.checkMathExpressionRegex();
        mathExpression.checkNonOperator();
        mathExpression.checkNullAndEmpty();
    }

    public int calculate() {
        mathExpression.removeWhiteSpace();
        return mathExpression.calculate(currentCalculationResult);
    }
}
