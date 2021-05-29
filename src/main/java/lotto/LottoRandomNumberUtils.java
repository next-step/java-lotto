package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomNumberUtils implements LottoRandomNumber {
    private static final List<Integer> LOTTO_NUMBER_RANGE = LottoValidationUtils.lottoNumberRange();

    public LottoNumbers createRandomLotto() {
        List<LottoNumber> randomNumbers = new ArrayList<>();
        Collections.shuffle(LOTTO_NUMBER_RANGE);
        for (int number = 0; number < LottoValidationUtils.getLottoNumberSize(); number++) {
            randomNumbers.add(new LottoNumber(LOTTO_NUMBER_RANGE.get(number)));
        }
        return new LottoNumbers(randomNumbers);
    }
}
