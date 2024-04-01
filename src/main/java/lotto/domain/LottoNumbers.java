package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final List<Integer> ALL_NUMBERS = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    private final Set<Integer> lottoNumbers;

    public LottoNumbers() {
        Collections.shuffle(ALL_NUMBERS);
        this.lottoNumbers = ALL_NUMBERS.stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toSet());
    }

    public Set<Integer> getNumbers() {
        return lottoNumbers;
    }
}
