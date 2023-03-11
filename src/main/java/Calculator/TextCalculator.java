package Calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCalculator {
    public int add(String text) {
        if (text == null || text.isEmpty()) return 0;
        return sum(getNumbers(text));
    }

    private String[] getNumbers(String text) {
        return text.split(",|\\|");
    }

    private int sum(String[] numbers) {
        int sumNumber = 0;
        for (int i = 0; i < numbers.length; i++) {
            sumNumber += Integer.parseInt(numbers[i]);
        }
        return sumNumber;
    }
}
