package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberGenerator {
    private final static List<Integer> lottoNumberPool = initLottoNumberPool();

    public static LottoNumbersWrapper pickLottoNumber() {
        int[] numbers = new int[Config.LOTTO_NUMBER_COUNT];
        Collections.shuffle(lottoNumberPool);
        for (int index = 0; index < Config.LOTTO_NUMBER_COUNT; index++) {
            numbers[index] = lottoNumberPool.get(index);
        }
        List<Integer> collect = Arrays
                .stream(numbers)
                .boxed()
                .collect(Collectors.toList());
        return new LottoNumbersWrapper(collect);
    }

    private static List<Integer> initLottoNumberPool() {
        List<Integer> lottoNumberList = new ArrayList<>();
        IntStream
                .range(Config.LOTTO_NUMBER_RANGE_TO_MIN, Config.LOTTO_NUMBER_RANGE_TO_MAX)
                .forEach(lottoNumberList::add);
        return lottoNumberList;
    }


}
