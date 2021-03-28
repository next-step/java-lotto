package step2.domain;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoFixedLottoNumberGenerator implements LottoNumberGenerator {

    private final List<Integer> numbers;

    public LottoFixedLottoNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Set<Integer> getGeneratedNumbers() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
