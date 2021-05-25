package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoNumbers;
import lotto.model.LottoResult;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final Lotto lotto = new Lotto();
    private final LottoResult lottoResult = new LottoResult();

    public void lotto(){

        int buyCount = lotto.buyCount(inputView.money());
        List<LottoNumbers> lottoNumbers = lotto.autoLottoNumbers(buyCount);
        resultView.print(lottoNumbers);

        String numbers = inputView.numbers();
        WinningNumbers winningNumbers = new WinningNumbers(numbers);

        resultView.print();
        resultView.print(lottoResult.result(lottoNumbers, winningNumbers));
    }

}
