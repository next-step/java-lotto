package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;

public class LottoGenerate {
    private static final List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = IntStream.rangeClosed(LottoNumber.START_NUMBER, LottoNumber.END_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static List<LottoNumber> create() {
        shuffle(lottoNumbers);
        return lottoNumbers.stream()
                .limit(Lotto.LOTTO_COUNT)
                .collect(Collectors.toList());
    }
}
