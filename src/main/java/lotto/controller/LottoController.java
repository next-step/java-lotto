package lotto.controller;

import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.Rankings;
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

        Lotto winningLotto = Lotto.of(() -> Arrays.stream(InputView.inputWinningLottoNumbers())
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
        Rankings rankings = buyer.rankings(winningLotto);

        ResultView.printStatistics(buyCount, rankings);
    }
}
