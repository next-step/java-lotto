package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generate() {
        List<Integer> numbers = IntStream.rangeClosed(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());
        Collections.shuffle(numbers);
        Set<Integer> selectedNumbers = new HashSet<>(numbers.subList(0, Lotto.SIZE));

        return new Lotto(selectedNumbers);
    }

}
