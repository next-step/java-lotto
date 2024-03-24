package lotto.domain;

import lotto.numberdrawer.NumberDrawer;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static int LOTTO_PRICE = 1000;
    public static LottoTicket createLottoNumbers(int countOfLotto, NumberDrawer numberDrawer) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < countOfLotto; i++) {
            LottoNumbers lottoNumber = LottoNumbers.from(numberDrawer.drawnNumbers(LottoNumber.MAX_LOTTO_NUMBER, LottoNumbers.LOTTO_NUMBER_SIZE));
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
