package lotto.controller;

import lotto.model.LottoGame;
import lotto.model.LottoTicket;
import lotto.type.Winning;
import lotto.view.Input;
import lotto.view.Result;

import java.util.Map;

public class LottoController {
    private static final int DEFAULT_LOTTO_AMOUNT = 0;

    private LottoGame lottoGame;

    public void playGame() {

        int purchaseAmount = Input.getPurchaseAmount();
        lottoGame = new LottoGame();

        int lottoAmount = lottoGame.getLottoAmount(purchaseAmount);
        Result.printLottoAmount(lottoAmount);

        if (lottoAmount == DEFAULT_LOTTO_AMOUNT) {
            return;
        }

        LottoTicket lottoTicket = lottoGame.getLottoTicket();
        Result.printLottoNumbers(lottoTicket.getTicketInfo());

        gameStart(lottoTicket);
    }

    private void gameStart(LottoTicket lottoTicket) {
        String inputNumbers = Input.getPastLottoNumber();
        Integer bonusNumber = Input.getBonusLottoNumber();
        try {
            lottoGame.settingWinningNumber(inputNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            Result.notValidNumber();
            return;
        }
        Map<Winning, Integer> winningCount = lottoGame.setWinningCount(lottoTicket);
        Result.printWinningResult(winningCount);

        double margin = lottoGame.getMargin(winningCount);
        Result.printMargin(margin);
    }


}
