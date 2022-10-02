package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lotto {
    private final static List<Integer> lottoNumberPool = initLottoNumberPool();
    private final int[] numbers;

    Lotto() {
        this.numbers = pickLottoNumber();
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int getMatchCount(List<Integer> collectNumberList) {
        int matchCount = 0;
        for (int number : this.numbers) {
            if (collectNumberList.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private static List<Integer> initLottoNumberPool() {
        List<Integer> lottoNumberList = new ArrayList<>();
        IntStream
                .range(Config.LOTTE_NUMBER_RANGE_TO_MIN, Config.LOTTE_NUMBER_RANGE_TO_MAX)
                .forEach(lottoNumberList::add);
        return lottoNumberList;
    }

    private int[] pickLottoNumber() {
        int[] numbers = new int[Config.LOTTE_NUMBER_COUNT];
        Collections.shuffle(lottoNumberPool);
        for (int index = 0; index < Config.LOTTE_NUMBER_COUNT; index++) {
            numbers[index] = lottoNumberPool.get(index);
        }
        return numbers;
    }

}
