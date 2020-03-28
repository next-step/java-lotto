package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutomaticLottoGenerator {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private static List<Integer> lottoNumbers;

    static {
        lottoNumbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> generate() {
        Collections.shuffle(lottoNumbers);
        return IntStream.range(0, LOTTO_NUMBER_SIZE)
                .map(i -> lottoNumbers.get(i))
                .boxed()
                .collect(Collectors.toList());
    }
}
