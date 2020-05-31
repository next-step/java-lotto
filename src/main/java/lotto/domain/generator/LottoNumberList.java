package lotto.domain.generator;

import lotto.domain.number.LottoNumber;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoNumberList {
    private final List<LottoNumber> numbers;

    public LottoNumberList() {
        this.numbers = createNumbers();
    }

    private List<LottoNumber> createNumbers() {
        int initialValue = LottoNumber.MIN_VALUE;
        AtomicInteger value = new AtomicInteger(initialValue);

        return IntStream.generate(value::getAndIncrement)
                .limit(LottoNumber.MAX_VALUE)
                .boxed()
                .map(LottoNumber::new)
                .collect(toList());
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
