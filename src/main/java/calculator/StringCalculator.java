package calculator;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

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

    private static List<Integer> getNumbers(Expression expression) {
        String[] numbers = expression.numbers();
        return parseIntArray(numbers);
    }

    private static List<Integer> parseIntArray(String[] numbersOfString) {
        return Arrays.stream(numbersOfString)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(toList());
    }

    private static int sum(List<Integer> numbersOfString) {
        return numbersOfString.stream().reduce(0, Integer::sum);
    }

}
