package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {
    public static final int RANGE_START = 1;
    public static final int RANGE_CLOSED = 46;

    public static final int START_LOTTO_RANGE = 0;
    public static final int END_LOTTO_RANGE = 6;

    private final List<Integer> numbers;

    private Numbers() {
        List<Integer> numbers = IntStream.range(RANGE_START, RANGE_CLOSED)
                .boxed().collect(Collectors.toList());
        this.numbers = numbers;
    }

    public static Numbers create() {
        return new Numbers();
    }

    public List<Integer> createLottoNumbers() {
        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = new ArrayList<>(numbers.subList(START_LOTTO_RANGE, END_LOTTO_RANGE));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
