package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (input == null) {
            return 0;
        }
        if (input.isEmpty()) {
            return 0;
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        boolean b = m.find();
        if (b) {
            String group = m.group(1);
            String group2 = m.group(2);
            String[] split = group2.split(group);

            int sum = 0;
            for (String s : split) {
                int i = parseInt(s);
                if (i < 0) {
                    throw new RuntimeException("익셉션");
                }
                sum += i;
            }
            return sum;
        } else {

            String[] split = input.split(":|,");

            int sum = 0;
            for (String s : split) {
                int i = parseInt(s);
                if (i < 0) {
                    throw new RuntimeException("익셉션");
                }
                sum += i;
            }
            return sum;
        }

    }
}
