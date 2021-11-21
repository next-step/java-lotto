package lotto.domain.numbergenerator;

import lotto.domain.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumbers.LOTTO_NUMBERS;

public class RandomLottoNumbersGenerator extends AbstractNumberGenerator {

    public List<LottoNumber> generate() {
        Collections.shuffle(LOTTO_NUMBERS);

        return IntStream.range(0, LOTTO_NUMBERS_COUNT)
                .mapToObj(LOTTO_NUMBERS::get)
                .sorted()
                .collect(Collectors.toList());
    }
}
