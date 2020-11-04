package stringcalculator;

public class StringCalculator {

    public int sum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(input);
    }
}
