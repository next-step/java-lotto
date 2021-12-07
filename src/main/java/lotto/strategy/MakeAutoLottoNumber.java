package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MakeAutoLottoNumber implements MakeLottoNumber {
    private static final int START_SPLIT_NUMBERS = 0;
    private static final int END_SPLIT_NUMBERS = 6;
    private static final int START_RANGE_LOTTO_NUMBERS = 1;
    private static final int END_RANGE_LOTTO_NUMBERS = 46;

    @Override
    public List<LottoNumber> getLottoNumber() {
        List<LottoNumber> lottoNumbers = IntStream.range(START_RANGE_LOTTO_NUMBERS, END_RANGE_LOTTO_NUMBERS)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(START_SPLIT_NUMBERS, END_SPLIT_NUMBERS);
    }
}
