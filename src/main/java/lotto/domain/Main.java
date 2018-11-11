package lotto.domain;

import jdk.internal.util.xml.impl.Input;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String [] args) {
        Lotto lotto = new Lotto();
        int ticketCount = lotto.countTicket(InputView.inputPurchaseAmount());

        ResultView.printLottoTicketCount(ticketCount);

        List<Ticket> tickets = lotto.generateTickets(ticketCount);
        ResultView.printTickets(tickets);

        LottoMachine lottoMachine = new LottoMachine(lotto);
        GameResult gameResult = lottoMachine.playLotto(InputView.inputLastWeeksWinningNumbers(), InputView.inputBonusNumber());

        ResultView.printLottoResults(gameResult);
    }
}
