package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoGenerator {

    private static final List<Integer> fullLottoNumbers = getFullLottoNumbers();

    public Lotto generateLotto() {
        Collections.shuffle(fullLottoNumbers);
        List<Integer> lottoNumbers = fullLottoNumbers.stream()
                .limit(Lotto.LOTTO_SIZE)
                .collect(toList());
        return new Lotto(lottoNumbers);
    }

    private static List<Integer> getFullLottoNumbers() {
        return IntStream.rangeClosed(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
                .boxed()
                .collect(toList());
    }
}
