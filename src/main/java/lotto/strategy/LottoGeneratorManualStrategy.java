package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoGeneratorManualStrategy implements LottoGeneratorStrategy {
    private final String numbers;

    public LottoGeneratorManualStrategy(String numbers) {
        this.numbers = numbers;
    }

    @Override
    public Set<LottoNumber> generate() {
        return Arrays.stream(numbers.split(","))
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}
