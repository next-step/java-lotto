package lotto.domain.generator;

import lotto.domain.LottoNumber;
import lotto.domain.ticket.LottoTicket;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberRandomGenerator implements LottoNumberGenerator {
    private static final List<Integer> numbersBetweenLottoNumberRange
            = IntStream.rangeClosed(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    @Override
    public Set<LottoNumber> generate() {
        Collections.shuffle(numbersBetweenLottoNumberRange);

        return numbersBetweenLottoNumberRange.stream()
                .limit(LottoTicket.LOTTO_NUMBERS_SIZE)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }
}
