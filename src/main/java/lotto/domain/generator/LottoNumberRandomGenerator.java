package lotto.domain.generator;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberRandomGenerator implements LottoNumberGenerator{
    @Override
    public Set<LottoNumber> generate() {
        List<Integer> numbersBetweenLottoNumberRange = IntStream.rangeClosed(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbersBetweenLottoNumberRange);

        return numbersBetweenLottoNumberRange.stream()
                .limit(LottoTicket.LOTTO_NUMBERS_SIZE)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}
