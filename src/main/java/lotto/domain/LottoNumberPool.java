package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberPool {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_AMOUNT = 6;

    private static final List<LottoNumber> LOTTO_NUMBERS = new ArrayList<>();

    private LottoNumberPool() {
    }

    static {
        IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
                 .mapToObj(LottoNumber::new)
                 .forEach(LOTTO_NUMBERS::add);
    }

    public static List<LottoNumber> getLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
        return LOTTO_NUMBERS.stream()
                            .limit(LOTTO_NUMBER_AMOUNT)
                            .map(LottoNumber::new)
                            .collect(Collectors.toList());
    }
}
