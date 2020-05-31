package lotto.domain.generator;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class LottoNumberGenerator implements NumberGenerator<LottoNumber> {

    private final List<LottoNumber> numbers;

    public LottoNumberGenerator() {
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

    @Override
    public List<LottoNumber> getNumbers() {
        Collections.shuffle(this.numbers);

        return numbers.subList(0, LottoNumbers.LOTTO_SIZE)
                .stream()
                .sorted()
                .collect(toList());
    }
}
