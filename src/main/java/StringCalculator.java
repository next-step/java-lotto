import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final String SPACE_DELIMITER = " ";

    public List<String> split(String string) {
        return Arrays.stream(string.split(SPACE_DELIMITER)).collect(Collectors.toList());
    }

    public int calculate(String firstNumber, String secondNumber, String operatorString) {
        final int firstNumberInt = Integer.parseInt(firstNumber);
        final int secondNumberInt = Integer.parseInt(secondNumber);

        final Operator operator = OperatorFactory.createOperator(operatorString);

        return operator.calculate(firstNumberInt, secondNumberInt);
    }

    public int calculateString(String string) {
        final List<String> strings = split(string);
        int result = Integer.parseInt(strings.get(0));
        for (int i = 1; i < strings.size(); i += 2) {
            final String operator = strings.get(i);
            final String secondNumber = strings.get(i + 1);
            result = calculate(String.valueOf(result), secondNumber, operator);
        }
        return result;
    }
}
