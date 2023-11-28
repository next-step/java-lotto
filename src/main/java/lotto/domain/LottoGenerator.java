package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private final RandomNumberStrategy randomNumberStrategy;
    private final List<LottoNumber> possibleLottoNumbers;

    public LottoGenerator(RandomNumberStrategy randomNumberStrategy, List<LottoNumber> possibleLottoNumbers) {
        this.randomNumberStrategy = randomNumberStrategy;
        this.possibleLottoNumbers = possibleLottoNumbers;
    }

    public List<LottoNumber> createLotto() {
        shuffleTotalLottoNumbers(possibleLottoNumbers);
        return randomNumberStrategy.getRandomNumbers(possibleLottoNumbers);
    }

    private void shuffleTotalLottoNumbers(List<LottoNumber> possibleLottoNumbers) {
        Collections.shuffle(possibleLottoNumbers);
    }
}
