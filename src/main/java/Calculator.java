import java.util.Stack;

public class Calculator {

    public static CalculatorExpression calculate(String postfix) {
        Stack<CalculatorExpression> stack = new Stack<>();
        for (char c : postfix.toCharArray()) {
            switch (c) {
                case '+':
                    stack.push(new AddExpression(stack.pop(), stack.pop()));
                    break;
                case '-':
                    CalculatorExpression right = stack.pop();
                    CalculatorExpression left = stack.pop();
                    stack.push(new MinusExpression(left, right));
                    break;
                case '*':
                    stack.push(new MultiplicationExpression(stack.pop(), stack.pop()));
                    break;
                case '/':
                    CalculatorExpression dividend = stack.pop();
                    CalculatorExpression divisor = stack.pop();
                    stack.push(new DivideExpression(divisor, dividend));
                    break;
                default:
                    stack.push(new VariableExpression(c));
            }
        }
        return stack.pop();
    }
}
