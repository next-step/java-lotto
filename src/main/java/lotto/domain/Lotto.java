package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int MINIMUM_BALL_NUMBER = 1;
    private static final int MAXIMUM_BALL_NUMBER = 45;

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validateRange(numbers);
        validateDuplicateNumber(numbers);
        validateSize(numbers);
        this.lottoNumbers = new ArrayList<>(numbers);
    }

    public List<Integer> getLotto() {
        return lottoNumbers;
    }

    public boolean contains(final int number) {
        return lottoNumbers.contains(number);
    }

    public int match(final Lotto lotto) {
        return (int) lotto.getLotto().stream()
            .filter(this::contains)
            .count();
    }

    public static void validateRange(final List<Integer> numbers) {
        numbers.forEach(Lotto::validateRange);
    }

    public static void validateRange(final int number) {
        if (number < MINIMUM_BALL_NUMBER || number > MAXIMUM_BALL_NUMBER) {
            throw new IllegalArgumentException(
                "[ERROR] " + MINIMUM_BALL_NUMBER + "부터 " + MAXIMUM_BALL_NUMBER + "까지의 숫자만 입력해주세요.");
        }
    }

    private static void validateDuplicateNumber(final List<Integer> numbers) {
        final List<Integer> deleteDuplicateNumbers = numbers.stream().distinct()
            .collect(Collectors.toList());
        if (numbers.size() != deleteDuplicateNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.");
        }
    }

    private static void validateSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 번호는 " + LOTTO_NUMBERS_SIZE + "개여야 합니다.");
        }
    }
}
