package lotto.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.number.LottoNumber.MAX_OF_LOTTO_NUMBER;
import static lotto.number.LottoNumber.MIN_OF_LOTTO_NUMBER;
import static lotto.number.LottoNumbers.NUMBER_OF_LOTTO_NUMBERS;

public final class LottoNumberGenerator {
    private static final int BASE_INDEX = 0;
    private static final List<LottoNumber> LOTTO_NUMBER_POOL =
            IntStream.rangeClosed(MIN_OF_LOTTO_NUMBER, MAX_OF_LOTTO_NUMBER)
                    .mapToObj(LottoNumber::from)
                    .collect(Collectors.toList());

    private LottoNumberGenerator() {}

    public static LottoNumbers generate() {
        Collections.shuffle(LOTTO_NUMBER_POOL);

        return LottoNumbers.from(extractLottoNumber());
    }

    private static List<LottoNumber> extractLottoNumber() {
        return Collections.unmodifiableList(
                new ArrayList<>(LOTTO_NUMBER_POOL.subList(BASE_INDEX, NUMBER_OF_LOTTO_NUMBERS))
        );
    }
}
