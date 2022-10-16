package com.game.lotto;

import com.game.lotto.number.ManualLottoNumberGenerator;
import com.game.lotto.number.RandomLottoNumberGenerator;
import com.game.lotto.play.LottoGame;
import com.game.lotto.ticket.WinnerTicket;
import com.game.lotto.ui.InputView;
import com.game.lotto.ui.ResultView;

import java.util.List;

public class LottoGameApplication {
    public static void main(String[] args) {
        int inputPrice = InputView.inputPrice();
        LottoGame lottoGame = new LottoGame(inputPrice, new RandomLottoNumberGenerator());

        List<Integer> winnerNumbers = InputView.inputLastWinnerNumber();
        int bonusNumber = InputView.inputBonusNumber();
        WinnerTicket winnerTicket = new WinnerTicket(new ManualLottoNumberGenerator(winnerNumbers), bonusNumber);
        ResultView.printResultMessage();
        lottoGame.compareWithWinnerTicketAndGetEarningRates(winnerTicket);
    }
}
