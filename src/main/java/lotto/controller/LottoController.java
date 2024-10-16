package lotto.controller;

import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.dto.LottoNumber;
import lotto.util.LottoNumbersCreator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void run() {
        int buyAmount = InputView.inputBuyAmount();
        int buyCount = InputView.calculateBuyCount(buyAmount);

        Buyer buyer = Buyer.of(buyCount, new LottoNumbersCreator());

        ResultView.printBuyerLottosInfo(buyer);

        Lotto winningLotto = Lotto.of(InputView::inputWinningLottoNumbers);
        LottoNumber bonusNumber = InputView.inputBonusLottoNumber();
        Result result = Result.of(buyer, winningLotto, bonusNumber);

        ResultView.printStatistics(buyCount, result);
    }
}
