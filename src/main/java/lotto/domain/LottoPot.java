package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoPot {
    private static final List<LottoNumber> LOTTO_NUMBERS;

    static {
        LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.START_LOTTO_NUMBER, LottoNumber.END_LOTTO_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static LottoNumber getOneRandomLottoNumber() {
        Collections.shuffle(LOTTO_NUMBERS);

        return LOTTO_NUMBERS.stream()
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
