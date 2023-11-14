package lotto.util;

import lotto.domain.wrapper.Numbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LottoNumber {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int SIZE = 6;

    public static Numbers drawLottoNumbers() {
        List<Integer> lottoNumbers = createLottoNumbers();
        Collections.shuffle(lottoNumbers);

        return new Numbers(lottoNumbers.stream()
            .limit(SIZE)
            .sorted()
            .collect(Collectors.toUnmodifiableList()));
    }

    private static List<Integer> createLottoNumbers() {
        return IntStream.range(MIN, MAX)
            .boxed()
            .collect(Collectors.toList());
    }
}
