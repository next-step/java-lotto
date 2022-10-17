package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class LottoNumberValidator {

    private static final String WRONG_COUNT_EXCEPTION_MESSAGE = "로또는 6개의 숫자를 가져야합니다.";
    private static final String DUPLICATED_NUMBER_EXCEPTION_MESSAGE = "로또의 숫자는 중복되지 않아야합니다.";
    private static final String WRONG_BONUS_NUMBER = "로또 번호는 반드시 1~45의 값 입니다.";

    private LottoNumberValidator() {
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(WRONG_COUNT_EXCEPTION_MESSAGE);
        }

        if(numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(WRONG_BONUS_NUMBER);
        }

        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
