package step4.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static final int MIN_LOTTO_RANGE = 1;
    private static final int MAX_LOTTO_RANGE = 45;
    private static final List<Integer> lottoNumbersCache = new ArrayList<>();
    private static final int LOTTO_NUMBER_COUNT = 6;

    static {
        IntStream.rangeClosed(MIN_LOTTO_RANGE, MAX_LOTTO_RANGE)
            .forEach(i -> lottoNumbersCache.add(i));
    }

    private LottoNumberGenerator() {
    }

    public static List<LottoNumber> generateAutoLottoNumber() {
        Collections.shuffle(lottoNumbersCache);

        return lottoNumbersCache.stream()
            .limit(LOTTO_NUMBER_COUNT)
            .map(number -> LottoNumber.from(number))
            .collect(Collectors.toList());
    }

    public static List<LottoNumber> generateManualLottoNumber(Set<Integer> manualNumbers) {
        return manualNumbers.stream()
            .map(number -> LottoNumber.from(number))
            .collect(Collectors.toList());
    }
}
