package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    public final static List<Lotto> LOTTO_NUMBERS;
    public final static int LOTTO_SIZE;
    public final static int MIN_RANGE = 1;
    public final static int MAX_RANGE = 46;

    static {
        LOTTO_NUMBERS = IntStream.range(MIN_RANGE, MAX_RANGE)
                .mapToObj(number -> new Lotto(number))
                .collect(Collectors.toList());

        LOTTO_SIZE = 6;
    }

    private LottoNumbers() {
    }
}
