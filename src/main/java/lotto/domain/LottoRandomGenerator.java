package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoRandomGenerator {

    private LottoRandomGenerator() {
    }

    public static Lotto generate() {
        List<LottoNumber> shuffleNumbers = LottoNumber.LOTTO_NUMBERS;
        Collections.shuffle(shuffleNumbers);

        return Lotto.of(shuffleNumbers.stream()
            .limit(Lotto.LOTTO_NUMBER_SIZE)
            .collect(Collectors.toList()));
    }
}
