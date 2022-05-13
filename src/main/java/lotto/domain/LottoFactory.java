package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    private static final int FIRST_LOTTO_NUMBER = 1;
    private static final int LAST_LOTTO_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    private static final List<LottoNumber> lottoBaseNumbers = new ArrayList<>();

    static {
        IntStream.rangeClosed(FIRST_LOTTO_NUMBER, LAST_LOTTO_NUMBER)
                .mapToObj(LottoNumber::valueOf)
                .forEach(lottoBaseNumbers::add);
    }

    private LottoFactory() {
    }

    public static Lotto createAutoLotto() {
        Collections.shuffle(lottoBaseNumbers);
        return new Lotto(
                lottoBaseNumbers.stream()
                .limit(LOTTO_COUNT)
                .collect(Collectors.toList()));
    }
}
