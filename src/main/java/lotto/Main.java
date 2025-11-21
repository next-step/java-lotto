package lotto;


import lotto.domain.*;

import java.util.List;

import static lotto.domain.LottoResult.*;
import static lotto.view.InputView.*;
import static lotto.view.InputView.inputBuyPrice;
import static lotto.view.ResultView.*;

public class Main {

    public static void main(String[] args) {
        printStart();
        LottoPrice lottoPrice = inputBuyPrice();
        printLottoCount(lottoPrice);

        List<LottoNumber> lottoNumbers = LottoMachine.createLotto(lottoPrice);
        printBuyLotto(lottoNumbers);


        printResultLottoNumber();
        LottoNumbers resultNumber = inputResultLottoNumber();
        printBonusNumber();
        int bonusNumber = inputBonusNumber();
        LottoNumber resultLottoNumber = new LottoNumber(resultNumber, bonusNumber);

        printResultMessage();
        LottoResult lottoResult = resultLottoNumber.checkLottoNumber(lottoNumbers);

        printResult(lottoResult);
        printProfit(profitPercent(lottoPrice));
    }
}
