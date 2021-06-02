package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final LottoMachine lottoMachine = new LottoMachine();

    public void lotto() {
        LottoResult lottoResult = new LottoResult();

        int money = moneyInput();

        int buyCount = lottoMachine.buyCount(money);
        int manualBuyCount = inputView.manualBuyCount();
        int autoBuyCount = buyCount - manualBuyCount;
        lottoMachine.buyCountValid(buyCount, manualBuyCount);

        Lottos lottoNumbers = lottoMachine.lottoNumbers(inputView.manualBuy(manualBuyCount), autoBuyCount);

        resultView.print(manualBuyCount, autoBuyCount);
        resultView.print(lottoNumbers);

        String numbers = inputView.numbers();
        LottoNumber bonusNumber = bonusNumber(numbers);

        resultView.print();
        WinningLotto winningLotto = new WinningLotto(new LottoNumbers(numbers), bonusNumber);
        resultView.print(lottoResult.lottoResult(lottoNumbers, winningLotto), lottoResult.rateOfReturn(money));
    }

    private int moneyInput() {
        int money = inputView.money();

        while (!lottoMachine.validateMoney(money)) {
            resultView.printInputMoneyError();
            money = inputView.money();
        }

        return money;
    }

    private LottoNumber bonusNumber(String numbers) {
        LottoNumber bonusNumber = LottoNumber.valueOf(inputView.bonusBall());

        while (!lottoMachine.useAbleBonusBall(numbers, bonusNumber)) {
            resultView.printBonusBallError();
            bonusNumber = LottoNumber.valueOf(inputView.bonusBall());
        }
        return bonusNumber;
    }

}
