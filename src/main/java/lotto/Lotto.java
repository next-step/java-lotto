package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final List<Integer> lottoNumbers = IntStream.rangeClosed(LOTTO_MIN, LOTTO_MAX)
            .boxed()
            .collect(Collectors.toList());

    public static List<Integer> getLotto() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, LOTTO_SIZE);
    }
}
