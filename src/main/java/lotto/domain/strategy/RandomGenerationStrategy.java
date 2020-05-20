package lotto.domain.strategy;

import lotto.domain.number.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerationStrategy implements NumberGenerationStrategy {

    private final int size;

    public RandomGenerationStrategy(final int size) {
        this.size = size;
    }

    @Override
    public List<Integer> generate() {
        final List<Integer> candidateLottoNumbers = generateRangeNumbers(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE);
        Collections.shuffle(candidateLottoNumbers);

        return candidateLottoNumbers.stream()
                .limit(size)
                .sorted()
                .collect(Collectors.toList());
    }

    private List<Integer> generateRangeNumbers(final int min, final int max) {
        return IntStream.rangeClosed(min, max)
                .boxed()
                .collect(Collectors.toList());
    }
}
