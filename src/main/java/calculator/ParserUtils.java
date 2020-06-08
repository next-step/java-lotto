package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserUtils {

    public static boolean checkEmpty(String input) {

        if (input.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean checkNull(String input) {

        if (input == null) {
            return true;
        }
        return false;
    }

    public static List<Integer> stringToArray(String input) {


        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return stringListToIntList(matcher.group(2).split(customDelimiter));
        }

        String[] splitText = input.split(",|:");
        return stringListToIntList(splitText);
    }

    private static List stringListToIntList(String[] splitText) {

        List resultList = new ArrayList();

        for (String text : splitText) {
            int number = Integer.parseInt(text.trim());
            isMinus(number);
            resultList.add(number);
        }
        return resultList;
    }

    private static void isMinus(int inputNumber) {
        if (inputNumber < 0) {
            throw new RuntimeException();
        }
    }
}
