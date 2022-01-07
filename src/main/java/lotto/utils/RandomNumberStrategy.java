package lotto.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoNumber;

public class RandomNumberStrategy implements NumberStrategy {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static List<Integer> numbers;

    private List<LottoNumber> randomNumbers;

    static {
        numbers = IntStream.rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
            .boxed()
            .collect(Collectors.toList());
    }

    public RandomNumberStrategy() {
        this.randomNumbers = getRandomNumbers().stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList());
    }

    @Override
    public List<LottoNumber> lottoNumbers() {
        return randomNumbers;
    }


    private List<Integer> getRandomNumbers() {
        Collections.shuffle(numbers);
        return numbers.stream()
            .limit(LOTTO_NUMBER_SIZE)
            .sorted()
            .collect(Collectors.toList());
    }

}
