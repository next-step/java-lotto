public interface CalculatorExpression {

    static final int RADIX = 10;
    VariableExpression calculate(VariableExpression result, VariableExpression variableExpression);
}
