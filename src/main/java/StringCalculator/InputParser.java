package StringCalculator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private static List<String> parseStringToStringList(String input) {
        if (input == null || "".equals(input)) {
            return Collections.singletonList("0");
        }

        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher m = pattern.matcher(input);
        if(m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return Arrays.asList(tokens);
        }

        return Arrays.asList(input.split("[,:]"));
    }

    public static List<Integer> parseStringListToIntegerList(String input) {

        List<String> parsedToStr = parseStringToStringList(input);
        List<Integer> parsedToInt = new LinkedList<>();
        parsedToStr.forEach(item -> parsedToInt.add(Integer.valueOf(item)));
        return parsedToInt;
    }
}
