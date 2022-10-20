package lotto.domain;

import java.util.*;
import java.util.stream.IntStream;

public class RandomNumberStrategy implements LottoNumberStrategy {
    private final static int END_OF_RANGE = 45;
    private final static int[] NUMBERS = IntStream.rangeClosed(1, END_OF_RANGE).toArray();
    private final static Random RANDOM = new Random();
    private final static int LOTTO_SIZE = 6;

    @Override
    public Set<Number> provideNumberSet() {
        Set<Number> collect = new TreeSet<>();
        while (collect.size() < LOTTO_SIZE) {
            collect.add(Number.of(NUMBERS[RANDOM.nextInt(END_OF_RANGE)]));
        }
        return collect;
    }
}
