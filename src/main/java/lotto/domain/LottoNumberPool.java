package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
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

    public static LottoNumber getLottoNumber() {
        Collections.shuffle(lottoNumbers);
        return new LottoNumber(lottoNumbers.get(0));
    }

    public static List<LottoNumber> getLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream()
                           .limit(6)
                           .map(LottoNumber::new)
                           .collect(Collectors.toList());
    }
}
