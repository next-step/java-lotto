package lotto.util;

import lotto.domain.lotto.wrapper.LottoNumber;
import lotto.domain.lotto.wrapper.LottoNumbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LottoMachine {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int SIZE = 6;

    private static final List<LottoNumber> lottoNumbers = IntStream.rangeClosed(MIN, MAX)
        .mapToObj(LottoNumber::of)
        .collect(Collectors.toList());

    public static List<LottoNumbers> drawNumbersByAuto(int countOfAuto) {
        return IntStream.range(0, countOfAuto)
            .mapToObj(i -> drawLottoNumbers())
            .collect(Collectors.toList());
    }

    private static LottoNumbers drawLottoNumbers() {
        Collections.shuffle(lottoNumbers);

        return new LottoNumbers(lottoNumbers.stream()
            .limit(SIZE)
            .collect(Collectors.toList()));
    }
}
