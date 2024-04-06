package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoFactory.ALL_NUMBERS;
import static lotto.domain.LottoFactory.LOTTO_SIZE;

public class NumbersGenerator {

    private final Set<Integer> lottoNumbers;

    public NumbersGenerator() {
        this.lottoNumbers = shuffle();
    }

    public Set<Integer> shuffle() {
        Collections.shuffle(ALL_NUMBERS);
        return ALL_NUMBERS.stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toSet());
    }

    public Set<Integer> getNumbers() {
        return lottoNumbers;
    }
}
