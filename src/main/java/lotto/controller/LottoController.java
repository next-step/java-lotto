package lotto.controller;

import lotto.model.LottoMachine;
import lotto.model.LottoNumbers;
import lotto.model.LottoResult;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public void lotto(){

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoMachine lottoMachine = new LottoMachine();
        LottoResult lottoResult = new LottoResult();

        int buyCount = lottoMachine.buyCount(inputView.money());
        List<LottoNumbers> lottoNumbers = lottoMachine.autoLottoNumbers(buyCount);
        resultView.print(lottoNumbers);

        String numbers = inputView.numbers();
        LottoNumbers winningNumbers = new LottoNumbers(numbers);

        resultView.print();
        resultView.print(lottoResult.result(lottoNumbers, winningNumbers));
    }

}
