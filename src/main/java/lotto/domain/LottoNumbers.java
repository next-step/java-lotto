package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.LottoAutoGenerator;

public class LottoNumbers {

    private final List<LottoNumber> numbers;

    public LottoNumbers(final List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicateNumber(numbers);

        this.numbers = numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public LottoNumbers() {
        this(LottoAutoGenerator.getInstance().generateLotto());
    }

    private void validateDuplicateNumber(final List<Integer> numbers) {
        HashSet<Integer> lottoDuplicate = new HashSet<>(numbers);
        if (numbers.size() != lottoDuplicate.size()) {
            throw new IllegalArgumentException("복권에 중복된 숫자가 존재합니다.");
        }
    }

    private void validateNumbersSize(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("복권의 숫자 개수가 유효하지 않습니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
