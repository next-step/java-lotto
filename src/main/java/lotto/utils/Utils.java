package lotto.utils;

import lotto.domain.LottoNo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {

    public static final int LOTTO_NUMBER_RANGE_START = 1;
    public static final int LOTTO_NUMBER_RANGE_END = 45;
    public static final int LOTTO_NUMBER_BOUND_START = 0;
    public static final int LOTTO_NUMBER_BOUND_END = 6;

    private Utils() {}

    public static List<LottoNo> generateRandomNumbers() {
        List<LottoNo> numbers = IntStream
                .rangeClosed(LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END)
                .mapToObj(LottoNo::new)
                .collect(Collectors.toList());

        return shuffle(numbers).subList(LOTTO_NUMBER_BOUND_START, LOTTO_NUMBER_BOUND_END);
    }

    private static List<LottoNo> shuffle(List<LottoNo> numbers) {
        Collections.shuffle(numbers);
        return numbers;
    }
}
