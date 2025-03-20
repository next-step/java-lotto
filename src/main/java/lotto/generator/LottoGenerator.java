package lotto.generator;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final NumberGenerator numberGenerator;

    public LottoGenerator(NumberGenerator generator) {
        this.numberGenerator = generator;
    }

    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            numbers.add(numberGenerator.generate(LOTTO_MAX_NUMBER));
        }
        return numbers;
    }

}
