import java.util.Objects;

public class Calculator {
    private static final String REGEX = " ";
    public static int calculate(String str) {
        isBlank(str);
        String[] arr = str.split(REGEX);
        int result = Integer.parseInt(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            String symbol = arr[i];
            Operation operation = Operation.valueOfSymbol(symbol);
            int number = Integer.parseInt(arr[++i]);
            result = operation.apply(result, number);
        }
        return result;
    }

    private static void isBlank(String str) {
        if (str == null || str.equals("") || str.equals(" ")) {
            throw new IllegalArgumentException();
        }
    }
}
