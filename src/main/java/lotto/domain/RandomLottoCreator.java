package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RandomLottoCreator implements LottoCreator {

    private static final int START = 1;
    private static final int ADD_NUM = 1;
    private static final int MAX_SIZE = 45;

    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 6;

    private static final List<Integer> CACHE =
        Stream.iterate(START, number -> number + ADD_NUM)
              .limit(MAX_SIZE)
              .collect(toList());

    @Override
    public Lotto create() {
        Collections.shuffle(CACHE);
        return Lotto.of(CACHE.subList(FROM_INDEX, TO_INDEX));
    }
}
