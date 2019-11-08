package lottery;

import lottery.domain.LottoNumber;
import lottery.domain.LottoTicket;
import lottery.domain.LottoTicketSeller;
import lottery.domain.LottoTickets;
import lottery.view.InputView;
import lottery.view.ResultView;

public class Main {

    public static void main(String[] args) {
        int purchaseAmount = InputView.payAmount();

        LottoTickets lottoTickets = LottoTicketSeller.purchaseRandomGames(purchaseAmount);
        ResultView.printLottoTickets(lottoTickets);

        LottoTicket winLottoTicket = InputView.getWinLottoTicket();
        LottoNumber bonusLottoNumber = InputView.getBonusNumber(winLottoTicket);
        LottoResults results = lottoTickets.match(winLottoTicket, bonusLottoNumber);
        ResultView.printLottoResults(results);
    }
}
