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
    private Set<Integer> numbers;

    private Lotto(final Set<Integer> numbers) {
        validation(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(final Set<Integer> numbers) {
        return new Lotto(numbers);
    }

    public Stream<Integer> stream() {
        return numbers.stream();
    }

    public boolean containBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public long matchCount(Lotto lotto) {
        List<Integer> numberList = lotto.stream().collect(Collectors.toList());
        return numbers.stream()
                .filter(number -> numberList.contains(number))
                .count();
    }


    private void validation(final Set<Integer> numbers) {
        if (numbers.size() != LOTTO_MADE_OF_NUMBERS) {
            throw new LottoException(LOTTO_NUMBERS_MADE_OF_SIX_NUMBERS);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
