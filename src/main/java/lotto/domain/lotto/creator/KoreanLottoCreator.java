package lotto.domain.lotto.creator;

import lotto.domain.lotto.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class KoreanLottoCreator implements LottoCreator {
    protected static final List<LottoNumber> numberData =
            IntStream.rangeClosed(LottoNumber.LOTTO_FIRST_NUMBER, LottoNumber.LOTTO_LAST_NUMBER)
                    .boxed()
                    .map(LottoNumber::new)
                    .collect(Collectors.toList());
}
