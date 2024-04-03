package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final Set<LottoNumber> numbers;

    private Lotto(final Set<LottoNumber> numbers) {
        validateNumbersHaveSpecifiedSize(numbers);

        this.numbers = numbers;
    }

    private void validateNumbersHaveSpecifiedSize(final Set<LottoNumber> numbers) {
        if (numbers.size() < LOTTO_NUMBERS_SIZE || numbers.size() > LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 지정된 개수보다 많거나 적을 수 없습니다. 개수: " + numbers.size());
        }
    }

    public int matchCount(final Lotto otherLotto) {
        return (int)this.numbers
                .stream()
                .filter(otherLotto.numbers::contains)
                .count();
    }

    public boolean contains(final LottoNumber number) {
        return this.numbers.contains(number);
    }

    public List<Integer> extractLottoNumbers() {
        return this.numbers
                .stream()
                .map(LottoNumber::value)
                .collect(Collectors.toList());
    }

    public static Lotto from(final List<Integer> numbers) {
        final Set<LottoNumber> lottoNumbers = toLottoNumbers(numbers);

        validateNumbersAreNotDuplicated(numbers, lottoNumbers);

        return new Lotto(lottoNumbers);
    }

    private static Set<LottoNumber> toLottoNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableSet());
    }

    private static void validateNumbersAreNotDuplicated(
            final List<Integer> numbers,
            final Set<LottoNumber> lottoNumbers
    ) {
        if (numbers.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다. 번호: " + numbers);
        }
    }
}
