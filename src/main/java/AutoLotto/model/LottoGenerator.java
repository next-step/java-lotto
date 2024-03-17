package AutoLotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static List<Integer> randomNumbers = new ArrayList<>();

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public LottoGenerator() {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            randomNumbers.add(i);
        }
    }

    public List<Integer> generateLottoNumbers(LottoGeneratorStrategy lottoGeneratorStrategy) {
        return lottoGeneratorStrategy.lottoGenerator(randomNumbers);
    }
}
