package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerLottoGenerator {

    public WinnerLotto createWinnerLotto(List<Integer> lotto, int bonusNumber) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : lotto) {
            lottoNumbers.add(LottoNumber.valueOf(number));
        }
        return new WinnerLotto(new Lotto(lottoNumbers), LottoNumber.valueOf(bonusNumber));
    }
}
