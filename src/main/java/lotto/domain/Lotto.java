package lotto.domain;

import lotto.exception.LottoException;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    private static final String LOTTO_NUMBERS_MADE_OF_SIX_NUMBERS = "로또는 6개의 숫자로 이루어져야 합니다.";
    private static final int LOTTO_MADE_OF_NUMBERS = 6;
    private Set<LottoNumber> numbers;

    private Lotto(final Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_MADE_OF_NUMBERS) {
            throw new LottoException(LOTTO_NUMBERS_MADE_OF_SIX_NUMBERS);
        }
        this.numbers = numbers;
    }

    public static Lotto of(final Set<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    public Stream<LottoNumber> stream() {
        return numbers.stream();
    }

    public boolean containBonusNumber(int bonusNumber) {
        return numbers.contains(new LottoNumber(bonusNumber));
    }

    public long matchCount(Lotto lotto) {
        List<LottoNumber> numberList = lotto.stream().collect(Collectors.toList());
        return numbers.stream()
                .filter(numberList::contains)
                .count();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Lotto lotto = (Lotto) object;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
