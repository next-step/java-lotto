package lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoRandomNumberUtil {
    private static final int NUMBER_OF_LOTTO_NUMBER = 6;
    private static final int BOUND_MIN = 1;
    private static final int BOUND_MAX = 46;
    private static final List<Integer> numbers = IntStream.range(BOUND_MIN, BOUND_MAX)
            .boxed()
            .collect(Collectors.toList());

    private LottoRandomNumberUtil() {
    }

    public static List<Integer> lottoNumbers() {
        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = new ArrayList<>(numbers.subList(0, NUMBER_OF_LOTTO_NUMBER));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
