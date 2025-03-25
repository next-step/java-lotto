package step2;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step2.Lotto.*;
import static step2.LottoNumber.*;

public class LottoNumberGenerator {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumberGenerator() {
        this.lottoNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());;
    }

    public List<LottoNumber> generate() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .collect(Collectors.toList());
    }
}
