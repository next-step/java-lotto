package lotto;

import lotto.model.wrapper.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.utils.LottoConstant.*;

public class AutomaticLottoGenerator {

    private static List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private AutomaticLottoGenerator() {
    }

    public static Set<LottoNumber> generate() {
        Collections.shuffle(lottoNumbers);
        return IntStream.range(0, LOTTO_NUMBER_SIZE)
                .mapToObj(i -> lottoNumbers.get(i))
                .collect(Collectors.toSet());
    }
}
