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
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        } else {
            return text.split(",|:");
        }
    }

    private int sum(String[] numbers) {
        int sumNumber = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(Integer.parseInt(numbers[i]) < 0){
                throw new RuntimeException();
            }
            sumNumber += Integer.parseInt(numbers[i]);
        }
        return sumNumber;
    }

}
