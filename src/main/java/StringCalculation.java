import operations.CalculateStrategy;
import operations.OperationStrategies;

public class StringCalculation {
    private final static String GAP = " ";

    public static String[] splitByGap(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("문자열이 입력안됐거나 공백 문자열 입니다.");
        }
        return str.split(GAP);
    }

    public static int getSum(String input) {
        String[] strings = splitByGap(input);

        int sum = 0;
        for (int i = 1; i < strings.length; i += 2) {
            sum = calculate(strings, sum, i);
        }
        return sum;
    }

    private static int calculate(String[] strings, int sum, int i) {
        CalculateStrategy operation = OperationStrategies.getOperation(strings[i]);
        if (i == 1) {
            sum += operation.calculate(Integer.parseInt(strings[i - 1]), Integer.parseInt(strings[i + 1]));
            return sum;
        }
        return operation.calculate(sum, Integer.parseInt(strings[i + 1]));
    }
}
