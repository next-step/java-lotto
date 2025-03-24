package lotto.domain.generate;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;

public class RandomLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generate() {
        List<Integer> numbers = IntStream.rangeClosed(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());
        Collections.shuffle(numbers);

        List<Integer> selectedNumbersList = numbers.subList(0, Lotto.SIZE);
        Collections.sort(selectedNumbersList);

        return new Lotto(selectedNumbersList);
    }

}
