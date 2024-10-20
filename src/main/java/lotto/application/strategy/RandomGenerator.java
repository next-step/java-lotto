package lotto.application.strategy;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomGenerator implements LottoNumberGenerator {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> baseNumbers;

    public RandomGenerator() {
        baseNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            baseNumbers.add(new LottoNumber(i));
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

        return new Lotto(baseNumbers.subList(0, LOTTO_NUMBER_COUNT).stream()
                .sorted()
                .collect(Collectors.toList())
        );
    }
}
