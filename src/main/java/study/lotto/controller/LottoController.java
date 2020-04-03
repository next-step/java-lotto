package study.lotto.controller;


import study.lotto.domain.LottoGame;
import study.lotto.domain.LottoIssuer;
import study.lotto.domain.LottoResult;
import study.lotto.domain.LottoWinningNumber;
import study.lotto.view.InputView;
import study.lotto.view.ResultView;

import java.util.List;

public class LottoController {
    public static void run() {
        int amount = InputView.getAmount();
        List<List<Integer>> customNumberList = InputView.getCustomNumbers();
        LottoIssuer lottoIssuer =
                CustomAndRandomLottoIssuer.valueOf(customNumberList, new RandomLottoIssuer());
        LottoGame lottoGame = new LottoGame(amount, lottoIssuer);
        ResultView.displayBuyingLotto(lottoGame.getLottos());

        List<Integer> winningNumbers = InputView.getWinningNumber();
        int bonusNumber = InputView.getBonusNumber();
        LottoResult lottoResult =
                lottoGame.result(new LottoWinningNumber(winningNumbers,
                        bonusNumber));
        ResultView.displayResult(lottoResult);
    }

    private LottoController() {
    }
}
