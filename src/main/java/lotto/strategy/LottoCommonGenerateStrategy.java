package lotto.strategy;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCommonGenerateStrategy implements LottoGenerateStrategy{

    private static final List<Integer> NUMBERS = IntStream.rangeClosed(LOTTO_MIN_NUM, LOTTO_MAX_NUM)
            .boxed()
            .collect(Collectors.toList());

    @Override
    public Set<Integer> generateLotto() {
        Collections.shuffle(NUMBERS);
        return new TreeSet<>(NUMBERS.subList(0, 6));
    }
}
