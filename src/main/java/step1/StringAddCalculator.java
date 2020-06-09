package step1;

import java.util.Arrays;

public class StringAddCalculator {
    private String[] formulaArray;

    public StringAddCalculator(String formula) {
        //this.formulaArray = formula;
    }

    public static int sum(String[] array) {
        validateNumbers(array);
        int total = 0;
        for (String number : array) {
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
