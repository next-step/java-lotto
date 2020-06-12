package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.PurchaseLottoInput;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputPurchaseLotto();

        PurchaseLottoInput purchaseLottoInput = inputView.getPurchaseLottoInput();
        List<Lotto> lottos = LottoFactory.createLottos(purchaseLottoInput);

        ResultView resultView = new ResultView();
        resultView.printLottos(lottos, purchaseLottoInput.getManualSize());

        inputView.inputWinningNumbersAndBonusNumber();
        LottoResult lottoResult = LottoResult.of(inputView.getWinningNumbers(), lottos);
        resultView.printStatistics(lottoResult, inputView.getPurchasePrice());
    }
}
