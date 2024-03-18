import operations.CalculateStrategy;
import operations.OperationStrategies;

public class StringCalculation {
    private final static String GAP = " ";

    public static String[] splitByGap(String str) {
        return str.split(GAP);
    }

    public static int calculate(String input) {
        String[] strings = splitByGap(input);

        int sum = 0;
        for (int i = 1; i < strings.length; i += 2) {
            sum = getSum(strings, sum, i);
        }
        return sum;
    }

    private static int getSum(String[] strings, int sum, int i) {
        CalculateStrategy operation = OperationStrategies.getOperation(strings[i]);
        if (i == 1) {
            sum += operation.calculate(Integer.parseInt(strings[i - 1]), Integer.parseInt(strings[i + 1]));
            return sum;
        }
        return operation.calculate(sum, Integer.parseInt(strings[i + 1]));
    }
}
