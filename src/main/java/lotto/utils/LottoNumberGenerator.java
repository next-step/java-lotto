package lotto.utils;

import addcalculator.exception.NotInstanceException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 46;
    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 6;

    private LottoNumberGenerator() {
        throw new NotInstanceException();
    }

    public static List<Integer> generateLottoNumbers() {
        return createLottoNumbers();
    }

    private static List<Integer> createLottoNumbers() {
        List<Integer> numbers = getLottoRangeNumbers();
        Collections.shuffle(numbers);

        return new ArrayList<>(numbers.subList(FROM_INDEX, TO_INDEX));
    }

    private static List<Integer> getLottoRangeNumbers() {
        return IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }


}
