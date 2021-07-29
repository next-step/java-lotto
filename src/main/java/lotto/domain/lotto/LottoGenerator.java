package lotto.domain.lotto;


import lotto.domain.lotto.number.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.lotto.Lotto.LOTTO_NUMBER_COUNT;
import static lotto.domain.lotto.number.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.lotto.number.LottoNumber.MIN_LOTTO_NUMBER;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_MAKER_INITIAL_INDEX = 0;
    private static final List<LottoNumber> LOTTO_NUMBERS =
            IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                    .mapToObj(LottoNumber::of)
                    .collect(Collectors.toList());

    private LottoGenerator() {}

    public static List<LottoNumber> generate() {
        Collections.shuffle(LOTTO_NUMBERS);

        return extractLottoNumber();
    }

    private static List<LottoNumber> extractLottoNumber() {
        return Collections.unmodifiableList(
                new ArrayList<>(LOTTO_NUMBERS.subList(LOTTO_NUMBER_MAKER_INITIAL_INDEX, LOTTO_NUMBER_COUNT))
        );
    }

}
