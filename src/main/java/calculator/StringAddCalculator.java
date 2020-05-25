package calculator;


public class StringAddCalculator {

    public int plus(String input) {
        if (input == null || input.replaceAll(" ", "").isEmpty()) {
            return 0;
        }

        int number = Integer.parseInt(input);
        return number;
    }
}
