package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.Lotto.LOTTO_MAX_NUMBER;
import static domain.Lotto.LOTTO_MIN_NUMBER;

public class LottoNumberGenerator {
    public List<Integer> generate() {
        List<Integer> lottoNumbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);

        return lottoNumbers.subList(0, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
