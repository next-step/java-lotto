package step1;

import java.util.Arrays;

public class Formula {
    private static String[] formulaArray;

    public Formula(String stringFormula) {
        if (stringFormula == null || stringFormula.trim().equals("")) {
            formulaArray = new String[]{"0"};

            return;
        }

        formulaArray = Separator.split(stringFormula);
        validateNumbers(formulaArray);
    }

    private void validateNumbers(String[] array) {
        Arrays.stream(array).forEach(number -> {
            if (Integer.parseInt(number) < 0) {
                throw new RuntimeException();
            }
        });
    }

    public String[] getArray() {
        return formulaArray;
    }
}
