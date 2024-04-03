package lotto.domain.publish;

import static lotto.domain.Lotto.LOTTO_NUMBERS_SIZE;
import static lotto.domain.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MINIMUM_LOTTO_NUMBER;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.LottoNumber;

public class RandomLottoNumbersPicker implements LottoNumbersPicker {

    private static final List<LottoNumber> lottoNumbersRange = IntStream.rangeClosed(
                    MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    @Override
    public Set<LottoNumber> pick() {
        Collections.shuffle(lottoNumbersRange);

        return lottoNumbersRange.stream()
                .limit(LOTTO_NUMBERS_SIZE)
                .collect(Collectors.toUnmodifiableSet());
    }
}
