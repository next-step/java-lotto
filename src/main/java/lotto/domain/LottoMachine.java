package lotto.domain;

import lotto.numberdrawer.NumberDrawer;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoNumberValidator.LOTTO_NUMBER_SIZE;
import static lotto.domain.LottoNumberValidator.MAX_LOTTO_NUMBER;

public class LottoMachine {
    public static LottoNumbers createLottoNumbers(int countOfLotto, NumberDrawer numberDrawer) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < countOfLotto; i++) {
            LottoNumber lottoNumber = LottoNumber.from(numberDrawer.drawnNumbers(MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE));
            lottoNumbers.add(lottoNumber);
        }
        return LottoNumbers.from(lottoNumbers);
    }
}
