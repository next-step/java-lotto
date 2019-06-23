package stringAddCalculator;

import java.util.Arrays;
import java.util.Collections;

public class StringAddCalculator {

    public int add(String inputText) {
        if (isNullOrBlank(inputText)) {
            return 0;
        }
        String[] StringNumbers = splitString(inputText);
        int[] intNumbers = arrayStringToArrayInt(StringNumbers);
        return Arrays.stream(intNumbers).sum();
    }

    private int[] arrayStringToArrayInt(String[] stringNumbers) {
        return Arrays.stream(stringNumbers).mapToInt(Integer::parseInt).toArray();
    }

    private String[] splitString(String inputText) {
        return inputText.split(",");
    }

    private boolean isNullOrBlank(String inputText) {
        return inputText == null || inputText.isBlank();
    }
}
