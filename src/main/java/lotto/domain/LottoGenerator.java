package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    public static List<LottoNumber> generateLottoNumber() {
        List<LottoNumber> lottoNumbers = IntStream.range(1, 45)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);

        return lottoNumbers.subList(0, 6);
    }
}
