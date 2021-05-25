package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void lotto(){
        Lotto lotto = new Lotto();
        int buyCount = lotto.buyCount(inputView.money());
        List<LottoNumbers> lottoNumbers = lotto.autoLottoNumbers(buyCount);
        resultView.print(lottoNumbers);

        String numbers = inputView.numbers();
    }

}
