package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null) return 0;
        if (input.isEmpty()) return 0;

        if (input.length() == 1)
            return Integer.parseInt(input);


        String separator = ",|:";
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            separator = matcher.group(1);
            input = matcher.group(2);
        }

        String[] splitData = input.split(separator);
        int result = 0;
        for(String data:splitData) {
            int number = Integer.parseInt(data);
            if(number < 0)
                throw new RuntimeException("음수 값이 입력 되었습니다.");
            result += number;
        }

        return result;
    }
}
