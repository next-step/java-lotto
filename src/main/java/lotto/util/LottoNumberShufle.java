package lotto.util;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberShufle {

    private static final List<Integer> LOTTO_ENTRY = IntStream.rangeClosed(1, 45)
            .boxed().collect(Collectors.toList());

    public static Set<Integer> getAutoNumber() {
        Collections.shuffle(LOTTO_ENTRY);
        return new TreeSet<>(new ArrayList<>(LOTTO_ENTRY.subList(0, 6)));
    }

}
