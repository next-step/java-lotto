package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputPurchasePrice();

        List<Lotto> lottos = LottoFactory.createLottos(inputView.getPurchasePrice());
        ResultView resultView = new ResultView();
        resultView.printLottos(lottos);

        inputView.inputWinningNumbersAndBonusNumber();
        LottoResult lottoResult = LottoResult.of(inputView.getWinningNumbers(), lottos);
        resultView.printStatistics(lottoResult, inputView.getPurchasePrice());

    }

}
