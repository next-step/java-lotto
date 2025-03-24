package domain;

public class Calculator {

    public static int calculate(String string) {
        String[] tokens = string.split(" ");
        int result = Integer.parseInt(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            int nextNumber = Integer.parseInt(tokens[i + 1]);
            result += nextNumber;
        }

        return result;
    }
}
