package lotto.domain.machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {

    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int FIRST_COUNT = 0;
    private static final int LOTTO_NUMBER_COUNT = 6;

    @Override
    public List<Integer> get() {
        List<Integer> numbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toList());

        Collections.shuffle(numbers);
        return new ArrayList<>(numbers.subList(FIRST_COUNT, LOTTO_NUMBER_COUNT));
    }
}
