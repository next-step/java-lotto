package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final Set<LottoNumber> numbers;

    private Lotto(final Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public int countCommonNumbers(final Lotto otherLotto) {
        return (int)this.numbers
                .stream()
                .filter(otherLotto.numbers::contains)
                .count();
    }

    public List<Integer> extractLottoNumbers() {
        return this.numbers
                .stream()
                .map(LottoNumber::value)
                .collect(Collectors.toList());
    }

    public static Lotto from(final Set<LottoNumber> numbers) {
        validateNumbersHaveSpecifiedSize(numbers);

        return new Lotto(numbers);
    }

    private static void validateNumbersHaveSpecifiedSize(final Set<LottoNumber> numbers) {
        if (numbers.size() < LOTTO_NUMBERS_SIZE || numbers.size() > LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 지정된 개수보다 많거나 적을 수 없습니다. 개수: " + numbers.size());
        }
    }

    public static Lotto from(final int[] numbers) {
        final Set<LottoNumber> lottoNumbers = toLottoNumbers(numbers);

        validateNumbersAreNotDuplicated(numbers, lottoNumbers);

        return from(lottoNumbers);
    }

    private static Set<LottoNumber> toLottoNumbers(final int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toUnmodifiableSet());
    }

    private static void validateNumbersAreNotDuplicated(final int[] numbers, final Set<LottoNumber> lottoNumbers) {
        if (numbers.length != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다. 번호: " + Arrays.toString(numbers));
        }
    }
}
