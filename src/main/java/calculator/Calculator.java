package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public int add(String input) {
        int sum = 0;

        if(input == null || input.isEmpty()){
            return 0;
        }

        String delimiter = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            delimiter = m.group(1);
            String[] numbers = m.group(2).split(delimiter);

            for(String number : numbers) {
                sum += Integer.parseInt(number);
            }

            return sum;
        }

        String[] numbers = input.split(delimiter);
        for(String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }

}
