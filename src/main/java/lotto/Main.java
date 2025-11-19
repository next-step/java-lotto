package lotto;


import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPrice;
import lotto.domain.LottoResult;

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
        LottoNumber resultLottoNumber = inputResultLottoNumber();

        printResultMessage();
        LottoResult lottoResult = resultLottoNumber.checkLottoNumber(lottoNumbers);

        printResult(lottoResult);
        printProfit(profitPercent(lottoPrice));
    }
}
