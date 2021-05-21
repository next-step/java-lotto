package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final List<Integer> SAMPLE = IntStream.rangeClosed(START_NUMBER, END_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    private LottoNumberGenerator() {

    }

    public static List<Integer> get() {
        List<Integer> shuffle = new ArrayList<>(SAMPLE);
        Collections.shuffle(shuffle);
        shuffle = shuffle.subList(0, Lotto.LOTTO_SIZE);
        shuffle.sort(Integer::compareTo);
        return shuffle;
    }
}
