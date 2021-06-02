package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public void lotto() {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoMachine lottoMachine = new LottoMachine();
        LottoResult lottoResult = new LottoResult();

        int money = inputView.money();
        while (!lottoMachine.validateMoney(money)) {
            resultView.printInputMoneyError();
            money = inputView.money();
        }

        int buyCount = lottoMachine.buyCount(money);
        int manualBuyCount = inputView.manualBuyCount();

        List<LottoNumbers> lottoNumbers = lottoMachine.autoLottoNumbers(buyCount - manualBuyCount);
        resultView.print(lottoNumbers);

        String numbers = inputView.numbers();
        LottoNumber bonusNumber = LottoNumber.valueOf(inputView.bonusBall());

        while (!lottoMachine.useAbleBonusBall(numbers, bonusNumber)) {
            resultView.printBonusBallError();
            bonusNumber = LottoNumber.valueOf(inputView.bonusBall());
        }

        resultView.print();
        WinningLotto winningLotto = new WinningLotto(new LottoNumbers(numbers), bonusNumber);
        resultView.print(lottoResult.lottoResult(lottoNumbers, winningLotto), lottoResult.rateOfReturn(money));
    }

}
