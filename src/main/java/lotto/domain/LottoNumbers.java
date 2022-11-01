package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        validateCount(numbers);
        validateDistinct(numbers);
        this.numbers = numbers;
    }

    public static LottoNumbers of(List<Integer> numbers) {
        return new LottoNumbers(numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
    }

    public List<LottoNumber> getNumbers() {
        return List.copyOf(this.numbers)
            .stream()
            .sorted(Comparator.comparing(LottoNumber::getValue))
            .collect(Collectors.toList());
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    private void validateCount(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개입니다.");
        }
    }

    private void validateDistinct(List<LottoNumber> numbers) {
        long count = numbers.stream()
            .distinct()
            .count();
        if (count != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }
}
