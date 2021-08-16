package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers implements LottoNumbersCreator {

    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int COUNT = 6;
    private static List<Integer> numbers;

    static {
        numbers = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public LottoNumbers createLottoNumbers() {
        Collections.shuffle(numbers);
        List<Integer> result = new ArrayList<>(numbers.subList(0, COUNT));
        Collections.sort(result);
        return new LottoNumbers(result);
    }
}
