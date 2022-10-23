package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final double MIN_NUMBER = 1;
    private static final double MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        validateCount(numbers);
        validateDistinct(numbers);
        validateLottoNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(this.numbers)
            .stream()
            .sorted()
            .collect(Collectors.toList());
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개입니다.");
        }
    }

    private void validateDistinct(List<Integer> numbers) {
        long count = numbers.stream()
            .distinct()
            .count();
        if (count != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateLottoNumber(List<Integer> numbers) {
        if(containsNotLottoNumber(numbers)) {
            throw new IllegalArgumentException("당첨 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    private boolean containsNotLottoNumber(List<Integer> numbers) {
        return numbers.stream()
            .anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER);
    }
}
