package lotto.domain;

import lotto.numberdrawer.NumberDrawer;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoValidator.LOTTO_NUMBER_SIZE;
import static lotto.domain.LottoValidator.MAX_LOTTO_NUMBER;

public class LottoMachine {
    public static int LOTTO_PRICE = 1000;
    public static LottoTicket createLottoNumbers(int countOfLotto, NumberDrawer numberDrawer) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < countOfLotto; i++) {
            LottoNumbers lottoNumber = LottoNumbers.from(numberDrawer.drawnNumbers(MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE));
            lottoNumbers.add(lottoNumber);
        }
        return LottoTicket.from(lottoNumbers);
    }

    public static boolean isInputLowerThanPrice(int inputPrice) {
        return inputPrice < LOTTO_PRICE;
    }

    public static boolean isInputPriceUnitWrong(int inputPrice) {
        return inputPrice % LOTTO_PRICE != 0;
    }

}
