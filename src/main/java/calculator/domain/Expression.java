package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Expression {
    PLUS("+", AddExpression::new),
    MINUS("-", MinusExpression::new),
    MULTIPLICATION("*", MultiplicationExpression::new),
    DIVIDE("/", DivideExpression::new);

    private final String mark;
    private final BiFunction<Variable, Variable, CalculatorExpression> calculatorExpression;
    Expression(String mark, BiFunction<Variable, Variable, CalculatorExpression> expression) {
        this.mark = mark;
        calculatorExpression = expression;
    }

    static Expression of(String mark) {
        return Arrays.stream(Expression.values())
            .filter(expression -> expression.mark.equals(mark))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(String.format("해당 연산자는 존재하지 않습니다.")));
    }

    CalculatorExpression expression(Variable left, Variable right){
        return this.calculatorExpression.apply(left,right);
    }

}
