package lotto.controller;

import lotto.dto.ResultDto;
import lotto.entity.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class JavaLotto {

    private static final LottoMachine lottoMachine = new LottoMachine();
    private static final PrizeMoneyCalculator prizeMoneyCalculator = new PrizeMoneyCalculator();
    private static final InputView inputView = new InputView();

    private JavaLotto() {

    }

    public static void run() {
        int buyMoney = inputView.requestBuyMoney();
        List<Lotto> lottos = lottoMachine.insert(buyMoney);

        ResultView.printCreateLotto(lottos);

        String text = inputView.requestWinnerNumber();
        List<Integer> winningNumbers = WinningNumbers.numbers(text);
        List<PrizeMoney> prizeMonies = lottoMachine.winnerResult(lottos, winningNumbers);
        ResultDto result = prizeMoneyCalculator.result(prizeMonies, buyMoney);

        ResultView.printResult(result);
    }
}
