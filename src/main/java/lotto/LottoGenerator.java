package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * LottoGenerator 는 로또 자동생성시 번호를 전달해 줄 수 있다.
 */
public class LottoGenerator {
    private static final List<LottoNumber> LOTTO_NUMBERS;

    private static final int SEED = 1;
    private static final int INCREMENT = 1;
    private static final int TOTAL_LOTTO_NUMBER_COUNT = 45;
    private static final int DEFAULT_CHOICE_COUNT = 6;

    /**
     * 1부터 45까지 모든 LottoNumber 를 생성한다.
     */
    static {
        LOTTO_NUMBERS = Stream.iterate(SEED, i -> i + INCREMENT)
                .limit(TOTAL_LOTTO_NUMBER_COUNT)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    /**
     * @return LOTTO_NUMBERS 를 shuffle 한 후 6개만 골라 오름차순으로 정렬하여 반환한다.
     */
    public static List<LottoNumber> auto() {
        Collections.shuffle(LOTTO_NUMBERS);

        return LOTTO_NUMBERS.stream()
                .limit(DEFAULT_CHOICE_COUNT)
                .sorted()
                .collect(Collectors.toList());
    }
}
