package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final List<Integer> randomNumbers;

    public LottoGenerator() {
        randomNumbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            randomNumbers.add(i);
        }
    }

    public List<Integer> generateLottoNumbers(LottoStrategy lottoStrategy) {
        return lottoStrategy.lottoGenerator(randomNumbers);
    }
}
