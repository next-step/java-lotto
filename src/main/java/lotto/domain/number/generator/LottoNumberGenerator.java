package lotto.domain.number.generator;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.*;

public class LottoNumberGenerator implements NumberGenerator<LottoNumber> {
    private static final List<LottoNumber> numbers = LottoNumbers.createWholeLottoNumbers();

    @Override
    public List<LottoNumber> getNumbers() {
        Collections.shuffle(numbers);

        return numbers.subList(0, LottoNumbers.LOTTO_SIZE)
                .stream()
                .sorted()
                .collect(toList());
    }
}
