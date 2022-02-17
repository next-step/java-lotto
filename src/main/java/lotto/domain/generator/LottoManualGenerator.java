package lotto.domain.generator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.lotto.Number;

public class LottoManualGenerator implements LottoGenerator {

    private final List<Integer> numbers;

    public LottoManualGenerator(final Integer ...values) {
        this(Stream.of(values).collect(Collectors.toList()));
    }

    public LottoManualGenerator(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Number> generateNumbers() {
        return numbers.stream()
            .map(Number::new)
            .collect(Collectors.toList());
    }

}
