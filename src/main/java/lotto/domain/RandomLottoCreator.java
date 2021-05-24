package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RandomLottoCreator implements LottoCreator {

    private static final List<Integer> CACHE = Stream.iterate(1, i -> i + 1)
                                                     .limit(45)
                                                     .collect(toList());

    @Override
    public Lotto create() {
        Collections.shuffle(CACHE);
        return Lotto.of(CACHE.subList(0, 6));
    }
}
