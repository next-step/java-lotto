package lotto.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class RandomLottoNumbers implements LottoNumbers {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    private static List<Integer> numbers = IntStream
        .rangeClosed(MIN_VALUE, MAX_VALUE)
        .boxed()
        .collect(Collectors.toList());

    public RandomLottoNumbers() {
    }

    @Override
    public List<Integer> choose() {
        Collections.shuffle(numbers);
        return new ArrayList<>(numbers.subList(0, SIZE));
    }

}
