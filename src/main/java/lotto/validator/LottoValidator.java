package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class LottoValidator {

    private static final String WRONG_COUNT_EXCEPTION_MESSAGE = "로또는 6개의 숫자를 가져야합니다.";
    private static final String DUPLICATED_NUMBER_EXCEPTION_MESSAGE = "로또의 숫자는 중복되지 않아야합니다.";
    private static final String STRING_NUMBER_WRONG_CHARACTER = "문자열로 로또 번호를 입력한 경우 숫자, 공백, 콤마(,)만을 포함해야합니다.";
    private static final Pattern COMMON_SEPARATOR_PATTERN = Pattern.compile("^[0-9,\\s]*$");
    private LottoValidator() {
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(WRONG_COUNT_EXCEPTION_MESSAGE);
        }

        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public static void validate(String numbers) {
        if (!COMMON_SEPARATOR_PATTERN.matcher(numbers).matches()) {
            throw new IllegalArgumentException(STRING_NUMBER_WRONG_CHARACTER);
        }
    }
}
