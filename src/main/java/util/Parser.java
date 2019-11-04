package util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private static final String[] DEFAULT_DELIMITER = {",", ":"};
    private static final String CUSTOM_DELIMIT_START_STRING = "//";
    private static final int CUSTOM_DELIMITER_INDEX = 2;
    private static final int CUSTOM_DELIMITER_LAST_INDEX = 5;

    public static List<Integer> convertToInteger(String inputValue) {
        if (StringUtils.isEmpty(inputValue)) {
            return Collections.singletonList(0);
        }

        String[] splitValue = splitFrom(inputValue);
        return convertToNumbers(splitValue);
    }

    private static String[] splitFrom(String inputValue) {
        return (isCustom(inputValue))
                ? splitByCustomDelimiter(inputValue)
                : inputValue.split(Arrays.toString(DEFAULT_DELIMITER));
    }

    private static String[] splitByCustomDelimiter(String inputValue) {
        return checkCustomDelimit(inputValue).split(findCustomDelimiter(inputValue));
    }

    private static boolean isCustom(String inputValue) {
        return inputValue.startsWith(CUSTOM_DELIMIT_START_STRING);
    }

    private static String checkCustomDelimit(String inputValue) {
        if (!inputValue.contains("\\n")) {
            throw new IllegalArgumentException("커스텀구분자 정의는 //커스텀구분자\n 형식으로 입력해주세요.");
        }
        return inputValue.substring(CUSTOM_DELIMITER_LAST_INDEX);
    }

    private static String findCustomDelimiter(String inputValue) {
        return String.valueOf(inputValue.charAt(CUSTOM_DELIMITER_INDEX));
    }

    private static List<Integer> convertToNumbers(String[] split) {

        return Arrays.stream(split)
                .map(Parser::changeToNumber)
                .collect(Collectors.toList());
    }

    private static Integer changeToNumber(String string) {
        Integer number;
        try {
            number = Integer.parseUnsignedInt(string);
        } catch (Exception e) {
            System.out.println("fail number parsing : " + e);
            throw new IllegalArgumentException("기본구분자, 커스텀 구분자 외에 다른 문자를 입력할 수 없습니다.");
        }

        return number;
    }

}
