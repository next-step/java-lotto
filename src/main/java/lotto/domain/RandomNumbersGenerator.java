package lotto.domain;

import java.util.Collections;
import java.util.List;

public class RandomNumbersGenerator {
    private final RandomNumberStrategy randomNumberStrategy;
    private final List<LottoNumber> possibleLottoNumbers;

    public RandomNumbersGenerator(RandomNumberStrategy randomNumberStrategy, List<LottoNumber> possibleLottoNumbers) {
        this.randomNumberStrategy = randomNumberStrategy;
        this.possibleLottoNumbers = possibleLottoNumbers;
    }

    public List<LottoNumber> createRandomNumbers() {
        shuffleTotalLottoNumbers(possibleLottoNumbers);
        return randomNumberStrategy.getRandomNumbers(possibleLottoNumbers);
    }

    private void shuffleTotalLottoNumbers(List<LottoNumber> possibleLottoNumbers) {
        Collections.shuffle(possibleLottoNumbers);
    }
}
