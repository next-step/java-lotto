import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final String SPACE_DELIMITER = " ";

    public int calculateString(String string) {
        final List<String> strings = split(string);
        int result = Integer.parseInt(strings.get(0));
        for (int i = 1; i < strings.size(); i += 2) {
            final String operator = strings.get(i);
            final int secondNumber = Integer.parseInt(strings.get(i + 1));
            result = calculate(result, secondNumber, operator);
        }
        return result;
    }

    private static int calculate(int firstNumber, int secondNumber, String operatorString) {
        final Operator operator = ArithmeticOperator.from(operatorString);

        return operator.calculate(firstNumber, secondNumber);
    }

    private static List<String> split(String string) {
        return Arrays.stream(string.split(SPACE_DELIMITER)).collect(Collectors.toList());
    }
}
