package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {
    private static final int LOTTO_LENGTH = 6;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_LOTTO_NUMBER = 1;

    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicateNumber(numbers);
        for (Integer number : numbers) {
            validateNumber(number);
        }
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public int findMatchingNumberCount(List<Integer> winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }

    public boolean isContainBonusNumber(Integer bonusNum) {
        return numbers.stream().anyMatch(n -> n.equals(bonusNum));
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("로또 숫자 수는 6개여야 합니다.");
        }
    }

    private void validateNumber(Integer number) {
        if (number < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또는 0보다 커야 합니다.");
        }

        if (number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 최대 값은 45입니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        long length = numbers.stream().distinct().count();
        if (length != LOTTO_LENGTH) {
            throw new IllegalArgumentException("로또 수는 중복되면 안됩니다.");
        }
    }
}
