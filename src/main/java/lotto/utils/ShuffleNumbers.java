package lotto.utils;

import lotto.LottoNumber;
import lotto.game.Game;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShuffleNumbers {
    private static final List<Integer> numbers
            = IntStream.rangeClosed(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    public static List<Integer> generateLottoNumbers() {
        Collections.shuffle(numbers);
        return numbers.subList(0, Game.LOTTO_NUMBER_COUNT).stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
