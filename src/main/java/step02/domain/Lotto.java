package step02.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.rangeClosed;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    public static final List<LottoNumber> lottoAllNumbers =
        rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    private final List<LottoNumber> value;

    public Lotto(List<LottoNumber> value) {
        validateLotto(value);
        this.value = value;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers.stream().map(LottoNumber::new).collect(Collectors.toList()));
    }

    public static Lotto create() {
        Collections.shuffle(lottoAllNumbers);
        List<LottoNumber> lottoNumbers = lottoAllNumbers.subList(0, LOTTO_NUMBERS_SIZE).stream()
            .sorted()
            .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    public List<LottoNumber> getValue() {
        return value;
    }

    public LottoGrade getGradeByComparison(Lotto winningNumbers) {
        Set<LottoNumber> winningNumbersSet = new HashSet<>(winningNumbers.value);
        int count = (int) value.stream()
            .filter(winningNumbersSet::contains)
            .count();
        return LottoGrade.from(count);
    }

    private void validateLotto(List<LottoNumber> numbers) {
        validateSizeIsSix(numbers);
        validateIsSorted(numbers);
    }

    private void validateSizeIsSix(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개의 번호여야 합니다. | numbers: " + numbers);
        }
    }

    private void validateIsSorted(List<LottoNumber> numbers) {
        List<LottoNumber> sorted = numbers.stream().sorted().collect(Collectors.toList());
        if (!sorted.equals(numbers)) {
            throw new IllegalArgumentException("로또 번호는 정렬된 번호여야 합니다. | numbers: " + numbers);
        }
    }
}
