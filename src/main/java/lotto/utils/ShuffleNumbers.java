package lotto.utils;

import lotto.game.LottoNumber;
import lotto.game.LottoNumbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.game.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.game.LottoNumber.MIN_LOTTO_NUMBER;

public class ShuffleNumbers {
    private static final List<Integer> numbers;

    static {
        numbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<LottoNumber> generateLottoNumbers() {
        Collections.shuffle(numbers);
        return numbers.subList(0, LottoNumbers.LOTTO_NUMBER_COUNT).stream()
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
