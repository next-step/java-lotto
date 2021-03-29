package lotto.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.controller.LottoMachine.LOTTO_NUMBER_COUNT;
import static lotto.domain.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MINIMUM_LOTTO_NUMBER;

public class LottoGenerator {

    private LottoGenerator() {
    }

    private static final List<LottoNumber> lottoNumbers = IntStream.range(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    public static List<Lotto> getLotto(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> generateLotto())
                .collect(Collectors.toList());
    }

    private static Lotto generateLotto() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> collects = lottoNumbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .sorted(Comparator.comparingInt(LottoNumber::value))
                .collect(Collectors.toList());
        return new Lotto(collects);
    }
}
