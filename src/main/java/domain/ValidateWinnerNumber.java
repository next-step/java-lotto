package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidateWinnerNumber {
    private static final int LAST_NUMBER = 45;
    private static final int SIX = 6;
    private static final int ONE = 1;

    public ValidateWinnerNumber(String[] inputs, int bonus) {
        validate(inputs, bonus);
    }

    private void validate(String[] inputs, int bonus) {
        validateNumberIsSix(inputs);
        validateStringsDuplicate(inputs, bonus);
        validateNumberRange(inputs, bonus);
    }

    private void validateNumberRange(String[] inputs, int bonus) {
        boolean rangeValidate = Arrays.stream(inputs)
                .mapToInt(Integer::parseInt)
                .allMatch(c -> c <= LAST_NUMBER);


        if (bonus > LAST_NUMBER) {
            throw new IllegalArgumentException("보너스 숫자 범위 입력 오류!!");
        }

        if (!rangeValidate) {
            throw new IllegalArgumentException("숫자 범위 입력 오류!!");
        }
    }

    private void validateStringsDuplicate(String[] inputs, int bonus) {
        Set<String> set = new HashSet<>(Arrays.asList(inputs));
        set.add(String.valueOf(bonus));

        if (set.size() != inputs.length + ONE) {
            throw new IllegalArgumentException("중복 값 입력 에러!");
        }
    }

    private void validateNumberIsSix(String[] inputs) {
        if (inputs.length != SIX) {
            throw new IllegalArgumentException("숫자 개수 에러 ");
        }
    }
}
