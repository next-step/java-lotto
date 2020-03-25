package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private String input;
    public int sum(String input){
        String line = checkNumber(input);
        StringBuilder regex = new StringBuilder(",|:|;");
        line = hasCustomDelimeter(line, regex);
        String[] numbers = line.split(regex.toString());
        return calculate(numbers);
    }

    private String hasCustomDelimeter(String line, StringBuilder regex) {
        Matcher macher = Pattern.compile("//(.)\n(.*)").matcher(line);
        if(macher.find()) {
            regex.append("|"+macher.group(1));
            line = macher.group(2);
        }
        return line;
    }

    private int calculate(String[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i]);
        }
        return sum;
    }

    private String checkNumber(String input) {
        if (input == null) {
            return "0";
        }
        if (input.isEmpty()) {
            return "0";
        }
        return input;
    }
}
