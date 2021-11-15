package step1.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputUtil {

    private InputUtil() {
    }

    public static List<Integer> paresNumberList(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            List<String> numberList = Arrays.asList(m.group(2).split(m.group(1)));
            checkNumeric(numberList);
            checkBiggerThanZero(numberList);
            return mapStringToInt(numberList);
        }
        List<String> numberList = Arrays.asList(input.split(";|,"));
        checkNumeric(numberList);
        checkBiggerThanZero(numberList);
        return mapStringToInt(numberList);
    }

    public static void checkBiggerThanZero(List<String> input) {
        if (input.stream().anyMatch(i -> Integer.parseInt(i) > 5)) {
            throw new RuntimeException("0보다 작은 값이 존재합니다.");
        }
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

}
