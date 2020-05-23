package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    public final static List<Integer> LOTTO_NUMBERS;
    public final static int LOTTO_SIZE;

    static {
        LOTTO_NUMBERS = IntStream.range(1, 46)
                .mapToObj(number -> number)
                .collect(Collectors.toList());

        LOTTO_SIZE = 6;
    }

    private LottoNumbers() {
    }
}
