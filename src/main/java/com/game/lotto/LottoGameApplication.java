package com.game.lotto;

import com.game.lotto.number.ManualLottoNumberGenerator;
import com.game.lotto.number.RandomLottoNumberGenerator;
import com.game.lotto.play.LottoGame;
import com.game.lotto.ticket.Ticket;
import com.game.lotto.ui.InputView;
import com.game.lotto.ui.ResultView;

import java.util.List;

public class LottoGameApplication {
    public static void main(String[] args) {
        long inputPrice = InputView.inputPrice();
        LottoGame lottoGame = new LottoGame(inputPrice, new RandomLottoNumberGenerator());
        ResultView.printOutputCountMessage(lottoGame.getTicketCount());

        List<Integer> winnerNumbers = InputView.inputLastWinnerNumber();
        Ticket winnerTicket = new Ticket(new ManualLottoNumberGenerator(winnerNumbers));
        ResultView.printResultMessage();
        lottoGame.compareWithWinnerTicketAndGetEarningRates(winnerTicket);
    }
}
