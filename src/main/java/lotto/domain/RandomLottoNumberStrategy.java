package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomLottoNumberStrategy implements RandomNumberStrategy {

    private static final int REQUIRED_RANDOM_NUMBERS_SIZE = 6;

    @Override
    public List<LottoNumber> getRandomNumbers(List<LottoNumber> possibleLottoNumbers) {
        return createRandomNumbers(possibleLottoNumbers);
    }

    private List<LottoNumber> createRandomNumbers(List<LottoNumber> possibleLottoNumbers) {
        List<LottoNumber> randomNumbers = new ArrayList<>();
        for (int i = 0; i < REQUIRED_RANDOM_NUMBERS_SIZE; i++) {
            randomNumbers.add(possibleLottoNumbers.get(i));
        }
        return randomNumbers;
    }
}
