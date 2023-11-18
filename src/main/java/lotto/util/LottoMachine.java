package lotto.util;

import lotto.domain.lotto.wrapper.LottoNumbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LottoMachine {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int SIZE = 6;

    public static LottoNumbers drawLottoNumbers() {
        List<Integer> lottoNumbers = createLottoNumbers();
        Collections.shuffle(lottoNumbers);

        return new LottoNumbers(lottoNumbers.stream()
            .limit(SIZE)
            .collect(Collectors.toUnmodifiableSet()));
    }

    private static List<Integer> createLottoNumbers() {
        return IntStream.rangeClosed(MIN, MAX)
            .boxed()
            .collect(Collectors.toList());
    }
}
