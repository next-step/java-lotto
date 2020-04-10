package lotto;

import lotto.model.wrapper.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.model.LottoTicket.LOTTO_NUMBER_SIZE;
import static lotto.model.wrapper.LottoNumber.LOTTO_MAX_NUMBER;
import static lotto.model.wrapper.LottoNumber.LOTTO_MIN_NUMBER;

public class AutomaticLottoGenerator {

    private static List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public AutomaticLottoGenerator() {
    }

    public Set<LottoNumber> generate() {
        Collections.shuffle(lottoNumbers);
        return IntStream.range(0, LOTTO_NUMBER_SIZE)
                .mapToObj(i -> lottoNumbers.get(i))
                .collect(Collectors.toSet());
    }
}
