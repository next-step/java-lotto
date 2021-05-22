package lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class LottoNumbers {

    private final Set<Integer> numbers;

    public LottoNumbers(Collection<Integer> numbers) {
        this.numbers = Collections.unmodifiableSet(new TreeSet<>(numbers));

        validateNumbersSizeAndDuplicateNumbers();
        validateNumbersRange();
    }

    public static LottoNumbers of(Collection<Integer> numbers) {
        return new LottoNumbers(numbers);
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchCount(LottoNumbers lottoNumbers) {
        return (int) lottoNumbers.getNumbers()
                                 .stream()
                                 .filter(this.numbers::contains)
                                 .count();
    }

    private void validateNumbersSizeAndDuplicateNumbers() {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복 없는 6개의 수를 사용해야 합니다.");
        }
    }

    private void validateNumbersRange() {
        if (isLottoNumberRange()) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자만 사용해야 합니다.");
        }
    }

    private boolean isLottoNumberRange() {
        return numbers.stream()
                      .anyMatch(number -> number < 1 || number > 45);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
