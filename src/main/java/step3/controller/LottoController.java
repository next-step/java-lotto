package step3.controller;

import step3.domain.*;
import step3.ui.InputView;
import step3.ui.ResultView;

public class LottoController {
    public static void main(String[] args) {
        int amount = InputView.purchaseAmount();
        LottoGame lottoGame = new LottoGame(new Money(amount));

        Lotto winningNumbers = getWinningNumbers(lottoGame);
        BonusNumber bonusNumber = getBonusNumber(lottoGame, winningNumbers);

        Ranks ranks = lottoGame.getRanks(winningNumbers, bonusNumber);

        ResultView.showStatistics(ranks);
        ResultView.showRate(ranks);

    }

    private static BonusNumber getBonusNumber(LottoGame lottoGame, Lotto winningNumbers) {
        int bonusNum = InputView.getBonusNumber();
        return lottoGame.getBonusNum(winningNumbers,bonusNum);
    }

    private static Lotto getWinningNumbers(LottoGame lottoGame) {
        String winNum = InputView.getWinningNumbers();
        return lottoGame.getWinLottoNum(winNum);
    }
}
