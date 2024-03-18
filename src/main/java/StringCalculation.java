import operations.Add;
import operations.CalculateStrategy;
import operations.OperationStrategies;

import java.util.Arrays;
import java.util.IllformedLocaleException;
import java.util.List;
import java.util.Optional;

public class StringCalculation {
    public static String[] splitByGap(String str) {
        return str.split(" ");
    }

    public static int calculate(String input) {
        String[] strings = splitByGap(input);
        int sum = 0;
        for (int i = 1; i < strings.length; i += 2) {
            CalculateStrategy operation = OperationStrategies.getOperation(strings, i);
            sum += operation.calculate(Integer.parseInt(strings[i - 1]), Integer.parseInt(strings[i + 1]));
        }
        return sum;
    }
}
