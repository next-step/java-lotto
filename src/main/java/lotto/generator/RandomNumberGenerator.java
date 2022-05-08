package lotto.generator;

import lotto.domain.LottoMarkingNumbers;
import lotto.domain.LottoNumber;
import lotto.exception.NotSupportInstanceException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator {

    private static final int INITIAL_INDEX = 0;
    private static final List<Integer> NUMBERS = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    private RandomNumberGenerator() {
        throw new NotSupportInstanceException();
    }

    public static List<Integer> generate() {
        Collections.shuffle(NUMBERS);
        return NUMBERS.subList(INITIAL_INDEX, LottoMarkingNumbers.LOTTO_NUMBER_COUNT);
    }
}
