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

    private static final List<Integer> numbersRange = IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    @Override
    public Set<LottoNumber> pick() {
        Collections.shuffle(numbersRange);

        return numbersRange.stream()
                .limit(LOTTO_NUMBERS_SIZE)
                .map(LottoNumber::from)
                .collect(Collectors.toUnmodifiableSet());
    }
}
