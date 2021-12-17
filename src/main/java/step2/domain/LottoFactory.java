package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoFactory {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_TOTAL_COUNT = 6;
    private static final int LOTTO_NUMBER_MIN_INDEX = 0;
    private static final int LOTTO_NUMBER_MAX_INDEX = LOTTO_NUMBER_TOTAL_COUNT - 1;
    private static final List<LottoNumber> NUMBERS = IntStream
            .rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .mapToObj(LottoNumber::from)
            .collect(toList());
    private static final int LOTTO_PRICE = 1000;

    private LottoFactory() {
    }

    public static Lotto generate() {
        Collections.shuffle(NUMBERS);
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(LOTTO_NUMBER_MIN_INDEX, LOTTO_NUMBER_MAX_INDEX)
                .mapToObj(NUMBERS::get)
                .sorted()
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));

        return Lotto.from(lottoNumbers);
    }

    public static int getLottoPrice() {
        return LOTTO_PRICE;
    }
}
