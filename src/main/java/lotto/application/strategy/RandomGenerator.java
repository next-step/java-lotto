package lotto.application.strategy;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomGenerator implements LottoNumberGenerator {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> baseNumbers;

    public RandomGenerator() {
        baseNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            baseNumbers.add(i);
        }
    }

    @Override
    public List<Lotto> generate(int generateCount) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < generateCount; i++) {
            result.add(this.generate());
        }
        return result;
    }

    private Lotto generate() {
        Collections.shuffle(baseNumbers);

        List<Integer> numbers = baseNumbers.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(numbers);

        return new Lotto(numbers);
    }
}
