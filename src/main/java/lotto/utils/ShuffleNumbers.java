package lotto.utils;

import lotto.LottoNumber;
import lotto.game.Game;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.LottoNumber.MIN_LOTTO_NUMBER;

public class ShuffleNumbers {
    private static final List<Integer> numbers;

    static {
        numbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> generateLottoNumbers() {
        Collections.shuffle(numbers);
        return numbers.subList(0, Game.LOTTO_NUMBER_COUNT).stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
