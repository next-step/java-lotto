package step1;

import java.util.Arrays;

public class StringAddCalculator {
    private static String[] formulaArray;

    public StringAddCalculator(String formula) {
        formulaArray = Separator.split(formula);
        validateNumbers(formulaArray);
    }

    public int sum() {
        int total = 0;
        for (String number : formulaArray) {
            total += Integer.parseInt(number);
        }

        return total;
    }

    private static void validateNumbers(String[] array) {
        Arrays.stream(array).forEach(number -> {
            if (Integer.parseInt(number) < 0) {
                throw new RuntimeException();
            }
        });
    }

}
