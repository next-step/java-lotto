package lotto.model.generator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGenerator {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final NumberGenerator numberGenerator;

    public LottoGenerator(NumberGenerator generator) {
        this.numberGenerator = generator;
    }

    public List<Integer> generate() {
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < LOTTO_NUMBER_COUNT) {
            int number = numberGenerator.generate(LOTTO_MAX_NUMBER);
            uniqueNumbers.add(number);
        }

        return new ArrayList<>(uniqueNumbers);
    }

}
