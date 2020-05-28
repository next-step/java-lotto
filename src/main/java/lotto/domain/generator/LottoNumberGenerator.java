package lotto.domain.generator;

import lotto.domain.number.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class LottoNumberGenerator implements NumberGenerator {

    private final List<Integer> numbers;

    LottoNumberGenerator() {
        this.numbers = createNumbers();
    }

    private List<Integer> createNumbers() {
        int initialValue = LottoNumber.MIN_VALUE;
        AtomicInteger value = new AtomicInteger(initialValue);

        return IntStream.generate(value::getAndIncrement)
                .limit(LottoNumber.MAX_VALUE)
                .boxed()
                .collect(toList());
    }

    @Override
    public List<Integer> getNumbers() {
        Collections.shuffle(this.numbers);

        return numbers.subList(0, 5)
                .stream()
                .sorted()
                .collect(toList());
    }
}
