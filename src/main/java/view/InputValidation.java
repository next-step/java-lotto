package view;

import java.util.regex.Pattern;

import exception.NullAndEmptyException;

public class InputValidation {

    private static final Pattern VALID_INPUT_REGEX = Pattern.compile("[\\d */+-]+");

    public String validateNullAndEmpty(String input) {

        if (input == null || input.isEmpty()) {
            throw new NullAndEmptyException("빈 값이 입력되었습니다. 값을 입력하세요.");
        }

        if (!VALID_INPUT_REGEX.matcher(input).matches()) {
            throw new NullAndEmptyException("잘못된 문자열이 입력되었습니다.");
        }
        return input;
    }
}
