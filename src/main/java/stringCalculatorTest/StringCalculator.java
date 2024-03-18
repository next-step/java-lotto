package stringCalculatorTest;

public class StringCalculator {
    public static int addition(String input) {
        String[] tokens = input.split(" ");
        return Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[2]);
    }

    public static int subtract(String input) {
        String[] tokens = input.split(" ");
        return Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[2]);
    }

    public static int division(String input) {
        String[] tokens = input.split(" ");
        return Integer.parseInt(tokens[0]) / Integer.parseInt(tokens[2]);
    }

    public static int multiple(String input) {
        String[] tokens = input.split(" ");
        return Integer.parseInt(tokens[0]) * Integer.parseInt(tokens[2]);
    }

    public static int calculation(String input) {
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException("input value is blank");
        }

        String[] tokens = input.split(" ");

        for (int i = 1; i < tokens.length; i+=2) {
            if(!(tokens[i] == "+" ||  tokens[i] == "-" || tokens[i] == "/" || tokens[i] == "*" )){
                throw new IllegalArgumentException("input value is invalid operation symbol");
            }
        }

        return 0;
    }
}
