package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MAX_SIZE = 6;
    private static List<LottoNumber> lottoLists;

    static {
       lottoLists = IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
           .boxed().map(LottoNumber::new).collect(Collectors.toList());
    }

    public List<LottoNumber> generate() {
        Collections.shuffle(lottoLists);
        return lottoLists.stream().limit(LOTTO_MAX_SIZE).collect(Collectors.toList());
    }
}
