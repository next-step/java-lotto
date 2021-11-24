package lotto.domain.starategy;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Lotto.SIZE;
import static lotto.domain.LottoNumber.BOUND_END;
import static lotto.domain.LottoNumber.BOUND_START;

public class GetRandomLottoNumbers implements GetLottoNumbersStrategy {
    public static final List<LottoNumber> BOUND_LOTTO_NUMBERS = IntStream.rangeClosed(BOUND_START, BOUND_END)
            .mapToObj(i -> new LottoNumber(i))
            .collect(Collectors.toList());

    @Override
    public List<LottoNumber> getLotto() {
        Collections.shuffle(BOUND_LOTTO_NUMBERS);
        return new ArrayList<LottoNumber>(BOUND_LOTTO_NUMBERS.subList(0, SIZE));
    }
}
