package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidateWinnerNumber {

    private ValidateWinnerNumber() {
    }

    public static void validate(String[] inputs) {
        validateNumberIsSix(inputs);
        validateStringsDuplicate(inputs);
        validateNumberRange(inputs);
    }

    public static void validateNumberRange(String[] inputs) {
        boolean rangeValidate = Arrays.stream(inputs)
                .mapToInt(Integer::parseInt)
                .allMatch(c -> c <= 45);

        if (!rangeValidate) {
            throw new IllegalArgumentException("숫자 범위 입력 오류!!");
        }
    }

    public static void validateStringsDuplicate(String[] inputs) {
        Set<String> set = new HashSet<>(Arrays.asList(inputs));

        if (set.size() != inputs.length) {
            throw new IllegalArgumentException("중복 값 입력 에러!");
        }
    }

    public static void validateNumberIsSix(String[] inputs) {
        if (inputs.length != 6) {
            throw new IllegalArgumentException("숫자 개수 에러 ");
        }
    }
}
