package lotto.controller;

import lotto.model.LottoMachine;
import lotto.model.LottoNumbers;
import lotto.model.LottoResult;
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
            System.out.println("금액을 천원 단위로 입력 하세요.");
            money = inputView.money();
        }

        List<LottoNumbers> lottoNumbers = lottoMachine.autoLottoNumbers(lottoMachine.buyCount(money));
        resultView.print(lottoNumbers);

        LottoNumbers winningNumbers = new LottoNumbers(inputView.numbers());

        resultView.print();
        resultView.print(lottoResult.lottoResult(lottoNumbers, winningNumbers), lottoResult.rateOfReturn(money));
    }

}
