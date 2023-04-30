package lotto.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int DRAWN_NUMBER_INDEX = 0;

    private List<Integer> numbers;

    public LottoMachine() {
        this.numbers = initLottoNumbers();
    }

    public int drawnNumber() {
        Collections.shuffle(numbers);

        int drawnNumber = numbers.get(DRAWN_NUMBER_INDEX);

        numbers.remove(Integer.valueOf(drawnNumber));

        return drawnNumber;
    }

    public List<Integer> initLottoNumbers() {
        return IntStream.range(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX + 1)
                .boxed()
                .collect(Collectors.toList());
    }
}

