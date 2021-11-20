package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumbers.LOTTO_NUMBERS;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<LottoNumber> generate() {
        Collections.shuffle(LOTTO_NUMBERS);

        return IntStream.range(0, 6)
                .mapToObj(LOTTO_NUMBERS::get)
                .sorted()
                .collect(Collectors.toList());
    }
}
