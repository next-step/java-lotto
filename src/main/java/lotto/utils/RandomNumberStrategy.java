package lotto.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberStrategy implements NumberStrategy {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private List<Integer> numbers;

    public RandomNumberStrategy() {
        this.numbers = IntStream.rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
            .boxed()
            .collect(Collectors.toList());
    }

    @Override
    public List<Integer> lottoNumbers() {
        return getRandomNumbers();
    }


    private List<Integer> getRandomNumbers() {
        Collections.shuffle(numbers);
        return numbers.stream().limit(LOTTO_NUMBER_SIZE).sorted().collect(Collectors.toList());
    }

}
