package lotto.common;

import lotto.domain.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersMaker {
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private final static int SUB_START_POINT = 0;
    private final static int SUB_END_POINT = 6;
    private static List<LottoNumber> lottoNumbers;
    
    static {
        lottoNumbers = IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
          .mapToObj(LottoNumber::new)
          .collect(Collectors.toList());
    }
    
    public static List<LottoNumber> getNewLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        return IntStream.range(SUB_START_POINT, SUB_END_POINT)
          .mapToObj(i -> lottoNumbers.get(i).getCopied())
          .sorted()
          .collect(Collectors.toList());
    }
}
