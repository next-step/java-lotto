package calcalator.model;

public class Calculator {
    public static boolean isEmpty(String input) {
        return input == null || "".equals(input);
    }

    public static int parse(String input) throws NumberFormatException {
        if (isEmpty(input))
            return 0;
        return Integer.parseInt(input);
    }
}
