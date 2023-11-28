package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private final RandomNumberStrategy randomNumberStrategy;

    public LottoGenerator(RandomNumberStrategy randomNumberStrategy) {
        this.randomNumberStrategy = randomNumberStrategy;
    }

    public List<LottoNumber> createLotto(List<LottoNumber> possibleLottoNumbers) {
        shuffleTotalLottoNumbers(possibleLottoNumbers);
        return randomNumberStrategy.getRandomNumbers(possibleLottoNumbers);
    }

    private void shuffleTotalLottoNumbers(List<LottoNumber> possibleLottoNumbers) {
        Collections.shuffle(possibleLottoNumbers);
    }
}
