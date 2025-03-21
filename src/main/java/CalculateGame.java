
public class CalculateGame {
    public static void main(String[] args) {
        String input = InputView.getExpression();
        Expression expression = Expression.createExpression(input);
        Calculator calculator = new Calculator();
        int sum = calculator.calculate(expression);
        System.out.println(sum);
    }
}
