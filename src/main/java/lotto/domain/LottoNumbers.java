package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final List<Integer> allNumbers = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    private final List<Integer> lottoNumbers;

    public LottoNumbers() {
        Collections.shuffle(allNumbers);
        this.lottoNumbers = allNumbers.stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toList());
    }

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getNumbers() {
        return lottoNumbers;
    }
}
