package lotto;

import lotto.domain.Game;
import lotto.domain.LottoWon;
import lotto.domain.PositiveNumber;
import lotto.domain.rank.LottoRanks;
import lotto.domain.ticket.LottoTickets;
import lotto.view.InfoView;
import lotto.view.InputView;
import lotto.view.MatchResultView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        PositiveNumber money = inputView.money();
        LottoTickets manualLottoTickets = inputView.manualLottoTickets();

        Game game = Game.createWithManualTicketByMoney(manualLottoTickets, money);
        InfoView infoView = new InfoView(game);

        infoView.countOfTicket();
        infoView.ticketNumbers();

        LottoWon lottoWon = inputView.wonNumbers();
        LottoRanks match = game.match(lottoWon);

        MatchResultView matchResultView = new MatchResultView(game, match);

        matchResultView.printRanks();
        matchResultView.printYields();
    }
}
