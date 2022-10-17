import java.util.Objects;

public class Calculator {
    public static int calculate(String str) {
        isBlank(str);
        String[] arr = str.split(" ");
        int result = Integer.parseInt(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            try {
                int number = Integer.parseInt(arr[i]);
            } catch (NumberFormatException e) {
                String symbol = arr[i];
                if (Objects.equals(symbol, "+")) {
                    result += Integer.parseInt(arr[++i]);
                } else if (Objects.equals(symbol, "-")) {
                    result -= Integer.parseInt(arr[++i]);
                } else if (Objects.equals(symbol, "*")) {
                    result *= Integer.parseInt(arr[++i]);
                } else if (Objects.equals(symbol, "/")) {
                    result /= Integer.parseInt(arr[++i]);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
        return result;
    }

    private static void isBlank(String str) {
        if (str == null || str.equals("") || str.equals(" ")) {
            throw new IllegalArgumentException();
        }
    }
}
