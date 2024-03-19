package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoPrize.*;

public class LottoNumberGenerator {

    private static final List<Integer> ALL_LOTTO_NUMBER = IntStream.rangeClosed(1, 45)
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
