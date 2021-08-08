package stringaddcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String regex1 = "//(.+)\n";
        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher = pattern.matcher(input);

        StringBuffer sb  = new StringBuffer(",|:");

        if (matcher.find()) {
            sb.append("|");
            sb.append(matcher.group(1));
            input = input.split(regex1)[1];
        }

        String regex = sb.toString();
        String[] splits = input.split(regex);

        int sum = Arrays.stream(splits).mapToInt(Integer::parseInt).peek((it) -> {
            if (it < 0) {
                throw new RuntimeException("음수는 처리할 수 없습니다.");
            }
        }).reduce(0, Integer::sum);

        return sum;
    }
}
