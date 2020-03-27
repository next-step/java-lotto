package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;

public class LottoNumberAutoGenerator {
    private static final int ZERO_INDEX = 0;

    private static final int LOTTO_NUM_MIN = 1;
    private static final int LOTTO_NUM_MAX = 45;
    private static final int LOTTO_NUM_COUNT_LIMIT = 6;

    private static List<Integer> lottoNumbers = IntStream.rangeClosed(LOTTO_NUM_MIN, LOTTO_NUM_MAX)
            .boxed()
            .collect(Collectors.toList());

    public static List<Integer> get() {
        Collections.shuffle(lottoNumbers);
        List<Integer> selectedNumbers = lottoNumbers.subList(ZERO_INDEX, LOTTO_NUM_COUNT_LIMIT);
        selectedNumbers.sort(comparingInt(Integer::intValue));
        return selectedNumbers;
    }

    private LottoNumberAutoGenerator() {
    }
}
