package calculator.domain;

import calculator.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private static final String[] DEFAULT_DELIMITER = {",", ":"};
    private static final String CUSTOM_DELIMIT_START_STRING = "//";
    private static final int CUSTOM_DELIMITER_INDEX = 2;
    private static final int CUSTOM_DELIMITER_LAST_INDEX = 5;

    private String input;

    public Parser(String input) {
        this.input = input;
    }

    public List<Integer> getIntegers() {
        if (StringUtils.isEmpty(input)) {
            return Collections.singletonList(0);
        }

        if (isCustom()) {
            String[] split = checkCustomDelimit().split(findCustomDelimiter());
            return changeToIntegers(split);
        }

        String[] split = input.split(Arrays.toString(DEFAULT_DELIMITER));
        return changeToIntegers(split);
    }

    private boolean isCustom() {
        return input.startsWith(CUSTOM_DELIMIT_START_STRING);
    }

    private String checkCustomDelimit() {
        if (!input.contains("\\n")) {
            throw new IllegalArgumentException("커스텀구분자 정의는 //커스텀구분자\n 형식으로 입력해주세요.");
        }
        return input.substring(CUSTOM_DELIMITER_LAST_INDEX);
    }

    private String findCustomDelimiter() {
        return String.valueOf(input.charAt(CUSTOM_DELIMITER_INDEX));
    }

    private List<Integer> changeToIntegers(String[] split) {

        return Arrays.stream(split)
                .map(this::changeToInteger)
                .collect(Collectors.toList());
    }

    private Integer changeToInteger(String string) {
        Integer integer;
        try {
            integer = Integer.parseInt(string);
        } catch (Exception e) {
            throw new IllegalArgumentException("기본구분자, 커스텀 구분자 외에 다른 문자를 입력할 수 없습니다.");
        }

        checkNegative(integer);
        return integer;
    }

    private void checkNegative(Integer integer) {
        if (integer < 0) {
            throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
        }
    }

}
