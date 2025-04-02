package autoLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private final List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(1, 45)
                                                         .boxed()
                                                         .collect(Collectors.toList());
    List<Integer> generate() {
        List<Integer> shuffledNumbers = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(shuffledNumbers);
        return shuffledNumbers.stream()
                              .limit(6)
                              .sorted()
                              .collect(Collectors.toList());
    }

    List<List<Integer>> generateLottos(int count) {
        return IntStream.range(0, count)
                 .mapToObj(lotto -> generate())
                 .collect(Collectors.toList());
    }

}
