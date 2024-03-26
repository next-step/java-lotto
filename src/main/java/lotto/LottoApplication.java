package lotto;

import common.view.LottoInputView;
import common.view.ResultView;
import lotto.domain.LottoGame;
import lotto.domain.LottoMachine;

public class LottoApplication {
    public static void main(String[] args) {
        int amount = LottoInputView.requestPurchaseAmount();
        int ticketCount = LottoMachine.getTicketsCount(amount);
        ResultView.showTicketCount(ticketCount);

        LottoGame lottoGame = new LottoGame(ticketCount);
        lottoGame.playGame();
    }
}
