package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final List<LottoNumber> lottoNumber;

    static {
        lottoNumber = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public static Lotto lottoGenerator() {
        Collections.shuffle(lottoNumber);
        LottoFullNumber lottoFullNumber = new LottoFullNumber(lottoNumber);
        return new Lotto(lottoFullNumber);
    }
}
