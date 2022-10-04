package step02.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.rangeClosed;

public class Lotto {

    private static final int MIN_LOTTO_NUMBERS = 1;

    private static final int MAX_LOTTO_NUMBERS = 45;

    private static final int LOTTO_NUMBERS_SIZE = 6;

    public static final List<Integer> lottoAllNumbers = rangeClosed(MIN_LOTTO_NUMBERS, MAX_LOTTO_NUMBERS)
        .boxed().collect(Collectors.toList());

    private final List<Integer> value;

    public Lotto(List<Integer> value) {
        validateLotto(value);
        this.value = value;
    }

    public static Lotto create() {
        Collections.shuffle(lottoAllNumbers);
        List<Integer> lottoNumbers = lottoAllNumbers.subList(0, LOTTO_NUMBERS_SIZE).stream()
            .sorted()
            .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    public List<Integer> getValue() {
        return value;
    }

    public LottoGrade getGradeByComparison(Lotto winningNumbers) {
        HashSet<Integer> winningNumbersSet = new HashSet<>(winningNumbers.value);
        int count = (int) value.stream().filter(winningNumbersSet::contains).count();
        return LottoGrade.from(count);
    }

    private void validateLotto(List<Integer> numbers) {
        validateSizeIsSix(numbers);
        validateIsSorted(numbers);
        validateIsBetween(numbers);
    }

    private void validateSizeIsSix(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개의 번호여야 합니다. | numbers: " + numbers);
        }
    }

    private void validateIsSorted(List<Integer> numbers) {
        List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());
        if (!sorted.equals(numbers)) {
            throw new IllegalArgumentException("로또 번호는 정렬된 번호여야 합니다. | numbers: " + numbers);
        }
    }

    private void validateIsBetween(List<Integer> numbers) {
        numbers.forEach(this::lottoNumbersIsBetween);
    }

    private void lottoNumbersIsBetween(int target) {
        if (target < MIN_LOTTO_NUMBERS || target > MAX_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("로또 번호는 " + MIN_LOTTO_NUMBERS + " ~ " + MAX_LOTTO_NUMBERS + "사이의 번호여야 합니다. | number " + target);
        }
    }
}
