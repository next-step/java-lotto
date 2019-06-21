package calculator;

public class StringCalculator {

    public static int calculator(String inputOfString) {
        if(checkEmpty(inputOfString)){
            return 0;
        }
        Expression expression = Expression.from(inputOfString);
        expression.checkTokens();

        return sum(getNumbers(expression));
    }

    public static boolean checkEmpty(String inputOfString) {
        return (inputOfString == null || inputOfString.isEmpty());
    }

    private static Numbers getNumbers(Expression expression) {
        return expression.numbers();
    }

    private static int sum(Numbers numbers) {
        return numbers.sum();
    }

}
