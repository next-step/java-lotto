package lotto.utils;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoNumberGenerator {
    private static final List<Integer> VALID_LOTTO_NUMBERS;

    static {
        VALID_LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    private LottoNumberGenerator() {

    }

    public static List<LottoNumber> generateLottoNumbers() {
        Collections.shuffle(VALID_LOTTO_NUMBERS);
        return VALID_LOTTO_NUMBERS.subList(0, LottoNumbers.MAX_LENGTH_LOTTO)
                .stream()
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toList());
    }
}
