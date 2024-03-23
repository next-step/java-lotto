package autoLotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static autoLotto.model.LottoConstants.LOTTO_END_NUMBER;
import static autoLotto.model.LottoConstants.LOTTO_START_NUMBER;

public class LottoGenerator {
    private final List<Integer> randomNumbers;

    public LottoGenerator() {
        randomNumbers = new ArrayList<>();

        for (int i = LOTTO_START_NUMBER; i <= LOTTO_END_NUMBER; i++) {
            randomNumbers.add(i);
        }
    }

    public Set<LottoNumber> generateLottoNumbers(LottoGeneratorStrategy lottoGeneratorStrategy) {
        return lottoGeneratorStrategy.lottoGenerator(randomNumbers);
    }
}
