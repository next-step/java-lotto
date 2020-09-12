package step1.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static step1.util.StringUtils.makeNumberList;

public class StringAddCalculator {
    public static final String REGULAR_EXPRESSION = "[-_.~!@#$%^&*()=+{}?<>\n]";
    public static int splitAndSum(String input) {
        // 1
        if(StringUtils.isNotBlank(input)) {
            return 0;
        }
        // 2
        if(StringUtils.isNumeric(input)) {
            return Integer.parseInt(input.toString());
        }
        //3 & 4
        Pattern pattern = Pattern.compile(REGULAR_EXPRESSION);
        boolean result = pattern.matcher(input).find();
        if(!result) {
            return IntStream.of(splitNo(input)).sum();
        }
        // 5
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(m.find()) {
            return IntStream.of(splitDelimeter(m.group(1), m.group(2))).sum();
        }
        return Integer.parseInt(input.toString());
    }

    public static int[] splitNo(String input) {
        String[] tempNo = input.split(",|:");
        return makeNumberList(tempNo);
    }

    public static int[] splitDelimeter(String delimeter, String data) {
        String[] tempData = data.split(delimeter);
        return makeNumberList(tempData);
    }
}
