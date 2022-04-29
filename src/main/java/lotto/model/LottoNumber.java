package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final int LOTTO_NUMBER_RANGE_START = 1;
    private static final int LOTTO_NUMBER_RANGE_END = 45;
    private static final int LIMIT_ONE_NUMBER = 1;
    private static final int ONE_NUMBER_INDEX = 0;

    private final int value;
    private static final List<Integer> lottoNumberElements = IntStream.rangeClosed(LOTTO_NUMBER_RANGE_START,
            LOTTO_NUMBER_RANGE_END)
            .boxed()
            .collect(Collectors.toList());

    public LottoNumber() {
        this(create());
    }

    public LottoNumber(int value) {
        validateLottoNumber(value);
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    private static int create() {
        Collections.shuffle(lottoNumberElements);
        return lottoNumberElements.stream()
            .limit(LIMIT_ONE_NUMBER)
            .collect(Collectors.toList())
            .get(ONE_NUMBER_INDEX);
    }

    private void validateLottoNumber(int value) {
        if(value < LOTTO_NUMBER_RANGE_START || value > LOTTO_NUMBER_RANGE_END) {
            throw new IllegalArgumentException();
        }
    }
}
