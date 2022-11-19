package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final List<Integer> lottoNumbers;

    static{
        lottoNumbers = IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> getLottoNumbers(){
        return lottoNumbers;
    }
}
