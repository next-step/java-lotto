package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumberPool {

    private static final List<LottoNumber> lottoNumbers = new ArrayList<>();

    private LottoNumberPool() {
    }

    static {
        IntStream.rangeClosed(1, 45)
                 .mapToObj(LottoNumber::new)
                 .forEach(lottoNumbers::add);
    }

    public static List<LottoNumber> getLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, 6);
    }
}
