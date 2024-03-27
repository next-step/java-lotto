package lotto.domain;

import static lotto.config.LottoExceptionMessage.LOTTO_NUMBERS_MUST_HAVE_SPECIFIED_SIZE;

import java.util.Set;

public class Lotto {

    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final Set<LottoNumber> numbers;

    public Lotto(final Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public int countCommonNumbers(final Lotto otherLotto) {
        return (int)this.numbers
                .stream()
                .filter(otherLotto.numbers::contains)
                .count();
    }

    public static Lotto from(final Set<LottoNumber> numbers) {
        validateNumbersHaveSpecifiedSize(numbers);

        return new Lotto(numbers);
    }

    private static void validateNumbersHaveSpecifiedSize(final Set<LottoNumber> numbers) {
        if (numbers.size() < LOTTO_NUMBERS_SIZE || numbers.size() > LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_MUST_HAVE_SPECIFIED_SIZE.message(numbers.size()));
        }
    }
}
