package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static final int NUMBER_INDEX_FROM = 0;
    private static final int NUMBER_INDEX_TO = 6;

    private static final int LOTTO_RANGE_FROM = 1;
    private static final int LOTTO_RANGE_TO = 45;


    private static final List<Integer> ALL_LOTTO_NUMBER = IntStream.rangeClosed(LOTTO_RANGE_FROM, LOTTO_RANGE_TO)
            .boxed()
            .collect(Collectors.toList());


    public static List<Integer> generate() {
        Collections.shuffle(ALL_LOTTO_NUMBER);
        return new ArrayList<>(getSubList());
    }

    private static List<Integer> getSubList() {
        return ALL_LOTTO_NUMBER.subList(NUMBER_INDEX_FROM, NUMBER_INDEX_TO);
    }

}
