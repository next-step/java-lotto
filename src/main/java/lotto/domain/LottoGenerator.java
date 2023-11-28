package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private final RandomNumberStrategy randomNumberStrategy;

    public LottoGenerator(RandomNumberStrategy randomNumberStrategy) {
        this.randomNumberStrategy = randomNumberStrategy;
    }

    public List<LottoNumber> createLotto(List<LottoNumber> possibleLottoNumbers) {
        List<LottoNumber> defensivePossibleLottoNumbers = createDefensiveNumbers(possibleLottoNumbers);
        shuffleTotalLottoNumbers(defensivePossibleLottoNumbers);
        return randomNumberStrategy.getRandomNumbers(defensivePossibleLottoNumbers);
    }

    private List<LottoNumber> createDefensiveNumbers(List<LottoNumber> possibleLottoNumbers) {
        return new ArrayList<>(possibleLottoNumbers);
    }

    private void shuffleTotalLottoNumbers(List<LottoNumber> possibleLottoNumbers) {
        Collections.shuffle(possibleLottoNumbers);
    }
}
