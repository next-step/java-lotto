package lotto.util;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberShufle {

    public static final int MIN_NUMBER_BOUND = 1;
    public static final int MAX_NUMBER_BOUND = 45;
    public static final int SHUFFLE_MIN_NUMBER = 0;
    public static final int SHUFFLE_MAX_NUMBER = 6;

    private static final List<Integer> LOTTO_ENTRY = IntStream.rangeClosed(MIN_NUMBER_BOUND, MAX_NUMBER_BOUND)
            .boxed().collect(Collectors.toList());

    public static Set<Integer> getAutoNumber() {
        Collections.shuffle(LOTTO_ENTRY);
        return new TreeSet<>(new ArrayList<>(LOTTO_ENTRY.subList(SHUFFLE_MIN_NUMBER, SHUFFLE_MAX_NUMBER)));
    }

}
