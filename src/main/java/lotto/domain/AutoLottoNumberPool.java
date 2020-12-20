package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoNumberPool {
    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 6;
    private static final int MINIMUM_VALUE = 1;
    private static final int MAXIMUM_VALUE = 45;

    private static final List<LottoNumber> numbers = IntStream.range(MINIMUM_VALUE, MAXIMUM_VALUE + 1)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    private AutoLottoNumberPool() {
    }

    public static List<LottoNumber> getLottoNumbers() {
        Collections.shuffle(numbers);
        return new ArrayList<>(numbers.subList(FROM_INDEX, TO_INDEX));
    }
}
