package lotto.step2.domain;

import lotto.step2.exception.LottoException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private static final String LOTTO_NUMBERS_MADE_OF_SIX_NUMBERS = "로또는 6개의 숫자로 이루어져야 합니다.";
    private static final String OVERLAPPED_NUMBERS_NOT_PERMITTED = "로또는 6개의 숫자로 이루어져야 합니다.";
    private static final int LOTTO_MADE_OF_NUMBERS = 6;
    private List<Integer> numbers = new ArrayList<>();

    private Lotto(final int[] numbers) {
        for (int number : numbers) {
            this.numbers.add(number);
        }
    }

    public static Lotto of(final int[] numbers) {
        validation(numbers);
        return new Lotto(numbers);
    }

    private static void validation(final int[] numbers) {
        if (numbers.length != LOTTO_MADE_OF_NUMBERS) {
            throw new LottoException(LOTTO_NUMBERS_MADE_OF_SIX_NUMBERS);
        }

        List<Integer> numList = new ArrayList<Integer>(Arrays.stream(numbers)
                        .boxed()
                        .collect(Collectors.toList()));
        if (numbers.length != numList.stream()
                .distinct()
                .count()
        ) {
            throw new LottoException(OVERLAPPED_NUMBERS_NOT_PERMITTED);
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
