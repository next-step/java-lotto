package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    public static final int START_LOTTO_NUMBER = 1;
    public static final int END_LOTTO_NUMBER = 45;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumberGenerator() {
        lottoNumbers = IntStream.range(START_LOTTO_NUMBER, END_LOTTO_NUMBER)
                .mapToObj(value -> new LottoNumber(value))
                .collect(Collectors.toList());
    }

    public List<LottoNumber> lotto() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0,6)
                .stream()
                .sorted(LottoNumber::compareTo)
                .collect(Collectors.toList());
    }
}
