public class CalculatorApplication {

    public static void main(String[] args) {
        final String inputString = args[0];
        final Expression expression = Expression.createExpression(inputString);
        System.out.printf("덧셈 결과 : %s", expression.add());
    }
}
