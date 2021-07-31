package lotto;

import java.util.List;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto(CreateLottoNumbersStrategy createLottoNumbersStrategy) {
        lottoNumbers = new LottoNumbers(createLottoNumbersStrategy.getNumbersList());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }
}
