package step2.util;

import step2.constant.LottoConstant;
import step2.domain.lotto.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator implements NumberGenerator{

    @Override
    public List<LottoNumber> generator() {
        final List<LottoNumber> numbers = getLottoNumbers();
        Collections.shuffle(numbers);
        return numbers.subList(LottoConstant.START_LOTTO_NUMBER_RANGE, LottoConstant.END_LOTTO_NUMBER_RANGE);
    }

    private static List<LottoNumber> getLottoNumbers() {
        return IntStream.rangeClosed(LottoConstant.MIN_LOTTO_NUMBER, LottoConstant.MAX_LOTTO_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
