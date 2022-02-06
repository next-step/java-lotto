package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoGenerator {

    private static final LottoAutoGenerator INSTANCE = new LottoAutoGenerator();
    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_END_NUM = 45;
    private static final int LOTTO_SIZE = 6;
    private static final List<LottoNumber> ALL_LOTTO_NUMBERS;

    static {
        ALL_LOTTO_NUMBERS = IntStream.range(LOTTO_START_NUM, LOTTO_END_NUM)
            .boxed()
            .map(LottoNumber::from)
            .collect(Collectors.toList());
    }

    private LottoAutoGenerator() {
    }

    public static LottoAutoGenerator getInstance() {
        return INSTANCE;
    }

    public List<LottoNumber> generateLotto() {
        Collections.shuffle(ALL_LOTTO_NUMBERS);

        return ALL_LOTTO_NUMBERS.stream()
            .limit(LOTTO_SIZE)
            .collect(Collectors.toList());
    }
}
