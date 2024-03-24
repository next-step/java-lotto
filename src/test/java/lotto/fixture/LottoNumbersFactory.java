package lotto.fixture;

import lotto.domain.LottoNumbers;
import lotto.domain.PickedLottoNumbers;

import java.util.List;

public class LottoNumbersFactory {

    public static LottoNumbers of(List<Integer> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    // TODO 이상함;;
    public static PickedLottoNumbers of(LottoNumbers lottoNumbers) {
        PickedLottoNumbers pickedLottoNumbers = new PickedLottoNumbers();
        pickedLottoNumbers.add(lottoNumbers);
        return pickedLottoNumbers;
    }
}
