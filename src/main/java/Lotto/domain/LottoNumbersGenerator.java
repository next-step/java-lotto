package Lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersGenerator {
    private static final List<Integer> LOTTO_NUMBER_LIST = IntStream
            .range(LottoNumber.LOTTO_START_NUMBER, LottoNumber.LOTTO_LAST_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    public static LottoNumbers createNewLotto() {
        Collections.shuffle(LOTTO_NUMBER_LIST);
        return new LottoNumbers(LOTTO_NUMBER_LIST.subList(0, LottoNumbers.LOTTO_SIZE)
                .stream()
                .map(LottoNumber::from)
                .collect(Collectors.toSet()));
    }
}
