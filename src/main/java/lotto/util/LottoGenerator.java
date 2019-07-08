package lotto.util;

import lotto.model.Lottery;
import lotto.model.Number;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;
import static java.util.Collections.sort;

class LottoGenerator {

    private static final int LOTTO_FIRST_NUMBER = 0;
    private static final int LOTTO_LAST_NUMBER = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    static Lottery generate() {
        List<Integer> lotteryNumbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        shuffle(lotteryNumbers);

        List<Integer> pickNumbers = lotteryNumbers.subList(LOTTO_FIRST_NUMBER, LOTTO_LAST_NUMBER);

        sort(pickNumbers);

        return new Lottery(pickNumbers.stream().map(Number::of).collect(Collectors.toCollection(LinkedHashSet::new)));
    }
}
