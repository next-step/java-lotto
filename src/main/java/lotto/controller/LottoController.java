package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.PurchaseLottoInput;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputPurchaseLotto();

        PurchaseLottoInput purchaseLottoInput = inputView.getPurchaseLottoInput();
        Money money = Money.of(purchaseLottoInput.getPurchasePrice());
        List<Lotto> lottos = LottoFactory.createLottos(money, purchaseLottoInput.getManualLottoNumbers());

        ResultView resultView = new ResultView();
        resultView.printLottos(lottos, purchaseLottoInput.getManualSize());
        inputView.inputWinningNumbersAndBonusNumber();

        WinningNumbers winningNumbers = WinningNumbers.of(Lotto.of(inputView.getWinningNumbers()), LottoNumber.of(inputView.getBonusNumber()));
        LottoResult lottoResult = LottoResult.of(winningNumbers, lottos);
        resultView.printStatistics(lottoResult, money);
    }
}
