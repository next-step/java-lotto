package step3.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LottoNumbers {

    private final Set<Integer> numbers;

    public LottoNumbers(Collection<Integer> numbers) {
        this.numbers = Collections.unmodifiableSet(new HashSet<>(numbers));

        validateNumbersSize();
        validateNumbersRange();
        validateDuplicateNumber();
    }

    public static LottoNumbers of(Collection<Integer> numbers) {
        return new LottoNumbers(numbers);
    }

    private void validateNumbersSize() {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호의 개수는 6개여야 합니다.");
        }
    }

    private void validateNumbersRange() {
        if (isLottoNumberRange()) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자만 사용해야 합니다.");
        }
    }

    private void validateDuplicateNumber() {
        if (hasDuplicateNumber()) {
            throw new IllegalArgumentException("로또 번호는 중복된 수를 포함하면 안됩니다.");
        }
    }

    private boolean isLottoNumberRange() {
        return numbers.stream()
                      .anyMatch(number -> number < 1 || number > 45);
    }

    private boolean hasDuplicateNumber() {
        return new HashSet<>(numbers).size() != 6;
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

    @Override
    public String toString() {
        return numbers.toString();
    }
}
