package lotto.util;

import lotto.domain.LottoNumbers;
import lotto.strategy.ListSortOrMixStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int SIZE = 6;
    private static final List<Integer> lottoNumbersPool = new ArrayList<>();

    static {
        IntStream.range(1, 46)
                .forEach(number -> lottoNumbersPool.add(number));
    }

    public static LottoNumbers getLottoNumbers(ListSortOrMixStrategy listSortOrMixStrategy){
        listSortOrMixStrategy.sortOrMix(lottoNumbersPool);
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.addAll(lottoNumbersPool.subList(0, 6));
        return new LottoNumbers(lottoNumbers);
    }
}
