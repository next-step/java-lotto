package lotto.domain;

import java.util.List;

public class LottoRandomNumberStrategy implements RandomNumberStrategy {

    private static final int REQUIRED_RANDOM_NUMBERS_SIZE = 6;

    @Override
    public List<LottoNumber> getRandomNumbers(List<LottoNumber> possibleLottoNumbers) {
        return createRandomNumbers(possibleLottoNumbers);
    }

    private List<LottoNumber> createRandomNumbers(List<LottoNumber> possibleLottoNumbers) {
        return possibleLottoNumbers.subList(0, REQUIRED_RANDOM_NUMBERS_SIZE);
    }
}
