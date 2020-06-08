package dev.dahye.lotto.domain;

import dev.dahye.lotto.util.LottoNumberUtil;

import java.util.List;

import static java.util.Collections.shuffle;

public class LottoNumberExtractor {
    public static final int ZERO_VALUE = 0;

    public static List<Integer> createShuffled(int maxSize) {
        LottoNumberUtil.validateMaxSize(maxSize);
        List<Integer> numbers = LottoNumberUtil.getNumbers();
        shuffle(numbers);

        return numbers.subList(ZERO_VALUE, maxSize);
    }
}
