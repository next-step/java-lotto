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
            List<Integer> numberList = new ArrayList<>();
            numberList.add(0);
            Numbers numbers = new Numbers(numberList);
            return numbers;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            List<String> numberList = Arrays.asList(m.group(2).split(m.group(1)));
            checkNumeric(numberList);
            return new Numbers(mapStringToInt(numberList));
        }

        List<String> numberList = Arrays.asList(input.split(":|,"));
        checkNumeric(numberList);
        return new Numbers(mapStringToInt(numberList));
    }

    public static void checkNumeric(List<String> input) {
        try {
            input.stream().anyMatch(i -> Integer.parseInt(i) > 5);
        } catch (RuntimeException e) {
            throw new RuntimeException("숫자로 변환이 불가능합니다.");
        }
    }

    public static List<Integer> mapStringToInt(List<String> input) {
        return input.stream().map(i -> Integer.parseInt(i)).collect(Collectors.toList());
    }

    private static boolean checkNull(String input) {
        if (input == null || input.equals("") ) {
            return true;
        }
        return false;
    }
}
