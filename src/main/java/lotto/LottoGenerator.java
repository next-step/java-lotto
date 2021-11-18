package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
    private static final int TOTAL_LOTTO_NUMBER_COUNT = 45;
    private static final int DEFAULT_SELECT_COUNT = 6;

    public static List<LottoNumber> autoMode() {
        final List<LottoNumber> allLottoNumbers = Stream.iterate(1, i -> i + 1)
                .limit(TOTAL_LOTTO_NUMBER_COUNT)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        Collections.shuffle(allLottoNumbers);

        return allLottoNumbers.stream()
                .limit(DEFAULT_SELECT_COUNT)
                .sorted()
                .collect(Collectors.toList());
    }
}
