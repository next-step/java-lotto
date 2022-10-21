package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoRandomGenerator {

    private LottoRandomGenerator() {
    }

    public static Lotto generate() {
        List<LottoNumber> shuffleNumbers = LottoNumber.LOTTO_NUMBERS.keySet().stream()
            .map(LottoNumber::from)
            .collect(Collectors.toList());

        Collections.shuffle(shuffleNumbers);

        return Lotto.of(shuffleNumbers.stream()
            .limit(Lotto.LOTTO_NUMBER_SIZE)
            .mapToInt(LottoNumber::getNumber)
            .boxed()
            .collect(Collectors.toList()));
    }
}
