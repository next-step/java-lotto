package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    private static final int LOTTO_NUMBER_UNDER_BOUND = 1;
    private static final int LOTTO_NUMBER_UPPER_BOUND = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = IntStream.rangeClosed(LOTTO_NUMBER_UNDER_BOUND, LOTTO_NUMBER_UPPER_BOUND)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private LottoNumberGenerator() {
    }

    public static List<LottoNumber> generateLottoNumbers() {
        Collections.shuffle(lottoNumbers);

        return lottoNumbers.stream()
                .limit(LOTTO_NUMBERS_SIZE)
                .sorted()
                .collect(Collectors.toList());
    }
}
