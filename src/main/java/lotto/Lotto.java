package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final int MINIMUM_VALUE = 1;
    private static final int MAXIMUM_VALUE = 45;
    private static final int SELECT_QUANTITY = 6;

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto generate() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = MINIMUM_VALUE; i <= MAXIMUM_VALUE; i++) {
            lottoNumbers.add(i);
        }
        Collections.shuffle(lottoNumbers);
        List<Integer> numbers = lottoNumbers.subList(0, SELECT_QUANTITY);
        return new Lotto(numbers);
    }

    public static Lotto from(Lotto lotto) {
        return new Lotto(lotto.numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
