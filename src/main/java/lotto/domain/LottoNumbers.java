package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumbers {
    public static final List<LottoNumber> LOTTO_NUMBERS = new ArrayList<>();

    static {
        IntStream.range(1, 46)
                .mapToObj(LottoNumber::from)
                .forEach(LOTTO_NUMBERS::add);
    }
}
