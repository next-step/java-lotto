package lottery;

import lottery.domain.LottoMoney;
import lottery.domain.LottoNumber;
import lottery.domain.LottoTicket;
import lottery.domain.LottoTicketSeller;
import lottery.domain.LottoTickets;
import lottery.dto.LottoTries;
import lottery.dto.LottoResults;
import lottery.view.InputView;
import lottery.view.ResultView;

public class Main {

    public static void main(String[] args) {
        LottoMoney purchaseAmount = InputView.payAmount();
        LottoTries lottoTries = InputView.getManualLottoTry(purchaseAmount);

        LottoTickets lottoTickets = InputView.getManualLottoTickets(lottoTries.getManualTries());
        LottoTicketSeller.purchaseRandomGames(lottoTickets, lottoTries);

        ResultView.printLottoTickets(lottoTickets, lottoTries);

        LottoTicket winLottoTicket = InputView.getWinLottoTicket();
        LottoNumber bonusLottoNumber = InputView.getBonusNumber(winLottoTicket);

        LottoResults results = lottoTickets.match(winLottoTicket, bonusLottoNumber);
        ResultView.printLottoResults(results);
    }
}
