package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberGenerator {
    private final static List<Integer> lottoNumberPool = initLottoNumberPool();

    public static List<Integer> pickLottoNumber() {
        int[] numbers = new int[Config.LOTTE_NUMBER_COUNT];
        Collections.shuffle(lottoNumberPool);
        for (int index = 0; index < Config.LOTTE_NUMBER_COUNT; index++) {
            numbers[index] = lottoNumberPool.get(index);
        }
        return Arrays
                .stream(numbers)
                .boxed()
                .collect(Collectors.toList());
    }

    private static List<Integer> initLottoNumberPool() {
        List<Integer> lottoNumberList = new ArrayList<>();
        IntStream
                .range(Config.LOTTE_NUMBER_RANGE_TO_MIN, Config.LOTTE_NUMBER_RANGE_TO_MAX)
                .forEach(lottoNumberList::add);
        return lottoNumberList;
    }


}
