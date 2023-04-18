package step1;

import java.util.List;

public class StringSeparator {

    private static final String DIVIDED_ZERO_PATTER = "/ 0";

    private static final String INPUT_DELIMITER = " ";

    public List<String> separateByDelimiter(String input) {
        isNullOrEmpty(input);
        isDividedZero(input);

        String[] separatedInput = input.split(INPUT_DELIMITER);
        return List.of(separatedInput);
    }

    private void isNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("NULL 또는 공백은 입력할 수 없습니다.");
        }
    }

    private void isDividedZero(String input) {
        if (input.contains(DIVIDED_ZERO_PATTER)) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }
}
