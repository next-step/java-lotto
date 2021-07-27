package lotto.domain;

import static lotto.common.Properties.LOTTO_NUMBER_COUNT;
import static lotto.common.Properties.LOTTO_NUMBER_MAX;
import static lotto.common.Properties.LOTTO_NUMBER_MIN;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    private final static List<Integer> numbers = IntStream.rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
        .boxed()
        .collect(Collectors.toList());

    public static List<Integer> createRandomNumbers() {
        Collections.shuffle(numbers);

        return numbers.stream()
            .limit(LOTTO_NUMBER_COUNT)
            .collect(Collectors.toList());
    }

    public static boolean isValid(List<Integer> checkNumbers) {
        if (!numbers.containsAll(checkNumbers)) {
            return false;
        }

        if (checkNumbers.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
            return false;
        }

        return true;
    }
}
