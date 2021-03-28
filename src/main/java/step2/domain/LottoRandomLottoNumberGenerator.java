package step2.domain;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoRandomLottoNumberGenerator implements LottoNumberGenerator {

    private List<Integer> numbers;

    public LottoRandomLottoNumberGenerator() {
        this.numbers = IntStream.range(1, 46)
                .boxed()
                .collect(Collectors.toList());
    }

    public Set<Integer> getGeneratedNumbers() {
        Collections.shuffle(numbers);

        return numbers.stream()
                .limit(6)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
