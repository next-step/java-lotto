package autoLotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final List<Integer> randomNumbers;

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public LottoGenerator() {
        randomNumbers = new ArrayList<>();

        for (int i = MIN_NUMBER, j = 0; i <= MAX_NUMBER; i++, j++) {
            randomNumbers.add(i);
        }
    }

    public int[] generateLottoNumbers(LottoGeneratorStrategy lottoGeneratorStrategy) {
        return lottoGeneratorStrategy.lottoGenerator(randomNumbers);
    }
}
