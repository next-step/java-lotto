package step1;

import java.util.Arrays;

public class StringAddCalculator {
    private String[] formulaArray;

    public StringAddCalculator(String formula) {
        //this.formulaArray = formula;
    }

    public static int sum(String[] array) {
        int total = 0;
        for (String number : array) {
            total += Integer.parseInt(number);
        }

        return total;
    }

}
