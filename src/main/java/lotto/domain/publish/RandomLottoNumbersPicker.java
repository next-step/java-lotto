package lotto.domain.publish;

import static lotto.domain.Lotto.LOTTO_NUMBERS_SIZE;
import static lotto.domain.LottoNumber.LOTTO_NUMBERS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.domain.LottoNumber;

public class RandomLottoNumbersPicker implements LottoNumbersPicker {

    private static final List<LottoNumber> lottoNumbersPool = new ArrayList<>(LOTTO_NUMBERS.values());

    @Override
    public Set<LottoNumber> pick() {
        Collections.shuffle(lottoNumbersPool);

        return lottoNumbersPool.stream()
                .limit(LOTTO_NUMBERS_SIZE)
                .collect(Collectors.toUnmodifiableSet());
    }
}
