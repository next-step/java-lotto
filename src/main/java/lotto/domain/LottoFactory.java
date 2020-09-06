package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    private static final List<LottoNumber> LOTTO_NUMBERS = IntStream.rangeClosed(Lotto.LOTTO_START_NUM, Lotto.LOTTO_END_NUM)
                                                                    .boxed()
                                                                    .map(LottoNumber::of)
                                                                    .collect(Collectors.toList());

    public static Lotto create() {
        List<LottoNumber> lottoNumbers = LOTTO_NUMBERS;

        Collections.shuffle(lottoNumbers);

        List<LottoNumber> subLottoNumbers = lottoNumbers.subList(0, Lotto.NUMBER_OF_LOTTO);
        subLottoNumbers.sort(LottoNumber::compareTo);

        return new Lotto(subLottoNumbers);
    }
}