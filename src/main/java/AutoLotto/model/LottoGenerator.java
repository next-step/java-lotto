package autoLotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoGenerator {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private final List<Integer> randomNumbers;

    public LottoGenerator() {
        randomNumbers = new ArrayList<>();

        for (int i = LOTTO_START_NUMBER; i <= LOTTO_END_NUMBER; i++) {
            randomNumbers.add(i);
        }
    }

    public Set<LottoNumber> generateManualLottoNumbers(LottoGeneratorStrategy lottoGeneratorStrategy, List<Integer> manualNumbers) {
        return lottoGeneratorStrategy.lottoGenerator(manualNumbers);
    }

    public Set<LottoNumber> generateRandomLottoNumbers(LottoGeneratorStrategy lottoGeneratorStrategy) {
        return lottoGeneratorStrategy.lottoGenerator(randomNumbers);
    }
}
