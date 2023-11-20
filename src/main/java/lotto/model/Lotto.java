package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<Integer> CANDIDATE_NUMBERS = IntStream.range(1, 46)
            .boxed()
            .collect(Collectors.toList());

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = createLottoNumbers();
    }

    private static List<Integer> createLottoNumbers() {
        Collections.shuffle(CANDIDATE_NUMBERS);
        List<Integer> numbers = CANDIDATE_NUMBERS.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(numbers);
        return new ArrayList<>(numbers);
    }

    @Override
    public boolean equals(Object obj) {
        Lotto other = (Lotto) obj;
        return this.numbers.equals(other.numbers);
    }
}
