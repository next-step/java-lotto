package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumbersGenerator {

    private List<Number> numbers;

    public NumbersGenerator() {
        numbers = IntStream.rangeClosed(Number.MIN, Number.MAX)
                .mapToObj(Number::new)
                .collect(Collectors.toList());
    }

    public List<Number> autoGenerate() {
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(LottoNumbers.LOTTO_NUMBER_SIZE)
                .collect(Collectors.toList());
    }
}
