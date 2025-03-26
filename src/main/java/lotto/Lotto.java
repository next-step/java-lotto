package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    public static final int LOTTO_NUMBER_UPPER_BOUND = 45;

    private List<Integer> numbers;

    public Lotto() {
        List<Integer> lottoNumberCandidate = new ArrayList<>();
        for (int i = 1; i <= LOTTO_NUMBER_UPPER_BOUND; ++i) {
            lottoNumberCandidate.add(i);
        }
        Collections.shuffle(lottoNumberCandidate);
        this.numbers = sortNumbers(cropNumbers(lottoNumberCandidate));
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = sortNumbers(numbers);
    }

    private List<Integer> cropNumbers(List<Integer> numbers) {
        return numbers.subList(0, 6);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }
}
