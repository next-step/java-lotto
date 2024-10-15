package lotto.controller;

import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.dto.LottoNumber;
import lotto.util.LottoNumbersCreator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoController {


    public static void run() {
        int buyAmount = InputView.inputBuyAmount();
        int buyCount = InputView.calculateBuyCount(buyAmount);

        Buyer buyer = Buyer.of(buyCount, new LottoNumbersCreator());

        ResultView.printBuyerLottosInfo(buyer);

        Lotto winningLotto = Lotto.of(InputView::inputWinningLottoNumbers);
        Result result = Result.of(buyer, winningLotto);

        ResultView.printStatistics(buyCount, result);
    }
}
