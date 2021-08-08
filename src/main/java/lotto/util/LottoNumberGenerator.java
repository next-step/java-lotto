package lotto.util;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.strategy.ListSortOrMixStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    private static final List<LottoNumber> lottoNumbersPool = new ArrayList<>();

    static {
        IntStream.rangeClosed(1, 45)
                .forEach(number -> lottoNumbersPool.add(new LottoNumber(number)));
    }

    public static LottoNumbers getLottoNumbers(ListSortOrMixStrategy listSortOrMixStrategy){
        listSortOrMixStrategy.sortOrMix(lottoNumbersPool);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.addAll(lottoNumbersPool.subList(0, 6));
        return new LottoNumbers(lottoNumbers);
    }
}
