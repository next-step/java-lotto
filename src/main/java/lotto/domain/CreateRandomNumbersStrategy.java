package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static lotto.domain.LottoNumberDuplicateChecker.hasDuplicates;

public class CreateRandomNumbersStrategy implements CreateLottoNumbersStrategy {
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    @Override
    public List<LottoNumber> create() {
        final int lottoNumberLength = Lotto.getLottoNumbersLength();
        List<LottoNumber> lottoNumbers = new ArrayList<>(lottoNumberLength);
        while (lottoNumbers.isEmpty() || hasDuplicates(lottoNumbers)) {
            lottoNumbers = createRandomNumbers(lottoNumberLength);
        }
        return lottoNumbers;
    }

    private List<LottoNumber> createRandomNumbers(final int lottoNumberLength) {
        final List<LottoNumber> lottoNumbers = new ArrayList<>(lottoNumberLength);
        for (int i = 0; i < lottoNumberLength; i++) {
            final int randomNumber = createRandomNumber();
            lottoNumbers.add(LottoNumber.of(randomNumber));
        }
        return lottoNumbers;
    }

    private int createRandomNumber() {
        final int max = LottoNumber.MAX.getValue();
        final int min = LottoNumber.MIN.getValue();
        return RANDOM.nextInt(max) + min;
    }
}
