package lotto.step2.domain;

import lotto.step2.exception.LottoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final String LOTTO_NUMBERS_MADE_OF_SIX_NUMBERS = "로또는 6개의 숫자로 이루어져야 합니다.";
    private static final int LOTTO_MADE_OF_NUMBERS = 6;
    private List<Integer> numbers = new ArrayList<>();

    private Lotto(final int[] numbers) {
        for (int number : numbers) {
            this.numbers.add(number);
        }
    }

    public static Lotto of(final int[] numbers) {
        if (numbers.length != LOTTO_MADE_OF_NUMBERS) {
            throw new LottoException(LOTTO_NUMBERS_MADE_OF_SIX_NUMBERS);
        }
        return new Lotto(numbers);
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
