package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    public static final int START_LOTTO_NUMBER = 1;
    public static final int END_LOTTO_NUMBER = 45;
    private final List<Integer> lottoNumbers;

    public LottoNumberGenerator() {
        lottoNumbers = IntStream.range(START_LOTTO_NUMBER, END_LOTTO_NUMBER)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());
    }

    public List<Integer> lotto() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0,6)
                .stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }
}
