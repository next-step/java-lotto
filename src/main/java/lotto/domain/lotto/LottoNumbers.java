package lotto.domain.lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private final Set<Integer> numbers;

    private LottoNumbers(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoNumbers create() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < LOTTO_NUMBER_COUNT) {
            randomNumbers.add(LottoNumber.create());
        }

        return new LottoNumbers(randomNumbers);
    }

    public static LottoNumbers create(Set<Integer> randomNumbers) {
        return new LottoNumbers(randomNumbers);
    }

    public Set<Integer> getValues() {
        return Collections.unmodifiableSet(numbers);
    }
}
