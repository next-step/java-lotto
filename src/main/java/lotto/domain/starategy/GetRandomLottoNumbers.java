package lotto.domain.starategy;

import lotto.domain.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Lotto.SIZE;

public class GetRandomLottoNumbers implements GetLottoNumbersStrategy {
    private static Integer BOUND_START = 1;

    private static Integer BOUND_END = 45;

    public static final List<Number> BOUND_NUMBERS = IntStream.rangeClosed(BOUND_START, BOUND_END)
            .mapToObj(i -> new Number(i))
            .collect(Collectors.toList());

    @Override
    public List<Number> getLotto() {
        Collections.shuffle(BOUND_NUMBERS);
        List<Number> lottoNumbers = new ArrayList<Number>(BOUND_NUMBERS.subList(0, SIZE));
        return lottoNumbers;
    }
}
