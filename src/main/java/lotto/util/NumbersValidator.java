package lotto.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.lotto.number.Number;

public class NumbersValidator extends Validator {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final String COMMA = ",";

    private NumbersValidator() {
    }

    public static List<Number> validate(String input) {
        final List<Number> numbers = Arrays.stream(input.split(COMMA))
            .map(String::trim)
            .map(Number::new).collect(Collectors.toList());

        validateDuplicateNumbers(numbers);
        validateSize(numbers);
        return numbers;
    }

    private static void validateDuplicateNumbers(List<Number> numbers) {
        final Set<Number> deleteDuplicateNumbers = new HashSet<>(numbers);
        if (numbers.size() != deleteDuplicateNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.");
        }
    }

    private static void validateSize(List<Number> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 번호는 " + LOTTO_NUMBERS_SIZE + "개여야 합니다.");
        }
    }
}
