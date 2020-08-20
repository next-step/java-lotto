package step2.util;

import step2.constant.LottoConstant;
import step2.domain.lotto.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    private static final int START_LOTTO_NUMBER_RANGE = 0;
    private static final int END_LOTTO_NUMBER_RANGE = 6;

    public List<LottoNumber> generator() {
        List<LottoNumber> numbers = getLottoNumbers();
        Collections.shuffle(numbers);
        return numbers.subList(START_LOTTO_NUMBER_RANGE, END_LOTTO_NUMBER_RANGE);
    }

    private List<LottoNumber> getLottoNumbers() {
        return IntStream.rangeClosed(LottoConstant.MIN_LOTTO_NUMBER, LottoConstant.MAX_LOTTO_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
