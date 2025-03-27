package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class FakeStrategy implements GeneratorStrategy {
    private final List<Integer> numbers;

    public FakeStrategy(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Lotto generate() {
        return new Lotto(convert());
    }

    private List<LottoNumber> convert() {
        return this.numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }
}
