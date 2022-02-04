package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.LottoAutoGenerator;

public class LottoNumbers {

    private final List<Integer> numbers;

    public LottoNumbers(final List<Integer> numbers){
        validateNumbersSize(numbers);
        validateDuplicateNumber(numbers);
        validateNumberRange(numbers);
        this.numbers = new ArrayList<>(numbers);
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

    private void validateNumberRange(final List<Integer> numbers) {
        numbers.stream().filter(number -> number < 1 || number > 45)
            .findAny()
            .ifPresent(num -> {throw new IllegalArgumentException("복권의 숫자 범위가 유효하지 않습니다.");});
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
