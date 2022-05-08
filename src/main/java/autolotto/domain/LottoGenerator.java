package autolotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final List<Integer> numbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 6;

    public static Set<LottoNumber> generate() {
        Collections.shuffle(numbers);

        return numbers.subList(FROM_INDEX, TO_INDEX)
                .stream()
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
