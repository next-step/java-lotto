package lotto.domain;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumbers.LOTTO_NUMBERS;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public Set<LottoNumber> generate() {
        Collections.shuffle(LOTTO_NUMBERS);

        return IntStream.range(0, 6)
                .mapToObj(LOTTO_NUMBERS::get)
                .collect(Collectors.toSet());
    }
}
