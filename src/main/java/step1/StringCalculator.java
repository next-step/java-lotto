package step1;

import step1.operation.Operation;
import step1.operation.PlusOperation;

import java.util.Map;

public class StringCalculator {

    private static final Map<String, Operation> operations =
            Map.of("+", new PlusOperation());

    public static Integer calculate(String input) {
        String[] split = input.split(" ");
        Integer sum = null;
        Operation operation = null;
        for (String string : split) {
            if (sum == null) {
                sum = Integer.parseInt(string);
            } else if (operations.containsKey(string)) {
                operation = operations.get(string);
            } else {
                sum = operation.operate(sum, Integer.parseInt(string));
            }
        }
        return sum;
    }

}
