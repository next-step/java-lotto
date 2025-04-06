package autoLotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private final List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(1, 45)
                                                         .boxed()
                                                         .collect(Collectors.toList());

    Set<Integer> generate() {
        Collections.shuffle(LOTTO_NUMBERS);
        return LOTTO_NUMBERS.subList(0, 6)
                            .stream()
                            .collect(Collectors.toSet());
    }
}
