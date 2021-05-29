package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomNumberUtils implements LottoRandomNumber {
    private static final List<Integer> LOTTO_NUMBER_RANGE = LottoValidationUtils.lottoNumberRange();

    public LottoNumber createRandomLotto() {
        List<Integer> randomNumbers = new ArrayList<>();
        Collections.shuffle(LOTTO_NUMBER_RANGE);
        for (int number = 0; number < LottoValidationUtils.getLottoNumberSize(); number++) {
            randomNumbers.add(LOTTO_NUMBER_RANGE.get(number));
        }
        Collections.sort(randomNumbers);
        return new LottoNumber(randomNumbers);
    }
}
