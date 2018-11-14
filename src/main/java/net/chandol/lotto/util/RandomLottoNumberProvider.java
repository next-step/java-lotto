package net.chandol.lotto.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static net.chandol.lotto.util.LottoNumberConstants.LOTTO_MAX_NUMBER;
import static net.chandol.lotto.util.LottoNumberConstants.LOTTO_MIN_NUMBER;
import static net.chandol.lotto.util.LottoNumberConstants.LOTTO_NUMBER_SIZE;

public final class RandomLottoNumberProvider {
    public static List<Integer> getNumbers() {
        List<Integer> numbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed().collect(toList());

        Collections.shuffle(numbers);
        return numbers.subList(0, LOTTO_NUMBER_SIZE);
    }
}
