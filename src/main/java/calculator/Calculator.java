package calculator;

public class Calculator {

    public static final String REGEX_OF_DEFAULT_SEPARATOR = "[,:]";

    public static int calculate(String input) {
        String[] elementsOninput = input.split(REGEX_OF_DEFAULT_SEPARATOR);
        return sum(elementsOninput);
    }

    private static int sum(String[] elementsOninput) {
        int result = 0;
        for (String element : elementsOninput) {
            result += Integer.parseInt(element);
        }
        return result;
    }
}
