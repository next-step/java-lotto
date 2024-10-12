package stringcalculator.model;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private static final String EXCEPT_EXPRESSION_ERROR_MESSAGE = "올바른 수식을 입력하세요!";
    public static final String SEPERATOR = " ";

    private List<Number> numbers;
    private List<Operator> operators;
    private int numberIndex;
    private int operatorIndex;

    public Expression(List<Number> numbers, List<Operator> operators) {
        this.numbers = numbers;
        this.operators = operators;
        this.numberIndex = 0;
        this.operatorIndex = 0;
    }

    public static Expression createExpression(String expression) {
        validateExpression(expression);
        List<Number> numbers = new ArrayList<>();
        List<Operator> operators = new ArrayList<>();
        toList(expression, numbers, operators);
        return new Expression(numbers, operators);
    }

    private static void validateExpression(String expression) {
        if (isNull(expression) || isEmpty(expression)) {
            throw new IllegalArgumentException(EXCEPT_EXPRESSION_ERROR_MESSAGE);
        }
    }

    private static boolean isEmpty(String expression) {
        return expression.equals(" ");
    }

    private static boolean isNull(String expression) {
        return expression == null;
    }


    private static void toList(String expression, List<Number> numbers, List<Operator> operators) {
        String[] split = expression.split(SEPERATOR);
        for (int i = 0 ; i < split.length-1 ; i=i+2) {
            numbers.add(new Number(split[i]));
            operators.add(Operator.of(split[i+1]));
        }
        numbers.add(new Number(split[split.length-1]));
    }

    public Number getNextNumber() {
        return this.numbers.get(numberIndex++ % this.numbers.size());
    }

    public Operator getNextOperator() {
        return this.operators.get(operatorIndex++ % this.operators.size());
    }

    public int getOperatorSize() {
        return this.operators.size();
    }
}
