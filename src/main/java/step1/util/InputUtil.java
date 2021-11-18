package step1.util;

import step1.domain.Numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputUtil {

    private InputUtil() {
    }

    public static Numbers getNumbers(String input) {
        if (checkNull(input)) {
            String replacement = "0";
            List<String> numberList = Arrays.asList(replacement);
            Numbers numbers = new Numbers(numberList);
            return numbers;
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            List<String> numberList = Arrays.asList(m.group(2).split(m.group(1)));
            return new Numbers(numberList);
        }
        List<String> numberList = Arrays.asList(input.split(":|,"));
        return new Numbers(numberList);
    }

    private static boolean checkNull(String input) {
        if (input == null || input.equals("")) {
            return true;
        }
        return false;
    }
}
