package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    public final static int LOTTO_NUMBER_COUNT = 6;
    private final List<Number> numbers;

    public LottoNumbers() {
        this.numbers = IntStream.iterate(1, i -> i + 1)
                .limit(45)
                .mapToObj(Number::new)
                .collect(Collectors.toList());
    }

    public List<Number> lottoNumbers() {
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .collect(Collectors.toList());
    }

    public int size() {
        return numbers.size();
    }

    public List<Number> numbers() {
        return numbers;
    }
}
