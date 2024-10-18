package lotto.controller;

import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.Winning;
import lotto.model.dto.LottoNumber;
import lotto.util.LottoNumbersCreator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void run() {
        int buyAmount = InputView.inputBuyAmount();
        int buyCount = InputView.calculateBuyCount(buyAmount);

        Buyer buyer = new Buyer(buyCount, new LottoNumbersCreator());

        ResultView.printBuyerLottosInfo(buyer);

        Lotto winningLotto = new Lotto(InputView::inputWinningLottoNumbers);
        LottoNumber bonusNumber = InputView.inputBonusLottoNumber();
        Winning winning = new Winning(winningLotto, bonusNumber);
        Result result = new Result(buyer, winning);

        ResultView.printStatistics(buyCount, result);
    }
}
